class NumberContainers {
    HashMap<Integer,Integer>idx=new HashMap<>();
    HashMap<Integer,TreeSet<Integer>>num= new HashMap<>();
    public NumberContainers() {
        return ;
    }
    
    public void change(int index, int number) {
        if(idx.containsKey(index)){
            int prev=idx.get(index);
            num.get(prev).remove(index);
            if(num.get(prev).isEmpty())
                num.remove(prev);
        }
        if(num.containsKey(number)){
            num.get(number).add(index);
        }
        else{
            TreeSet<Integer>t= new TreeSet<>();
            t.add(index);
            num.put(number,t);
        }
        idx.put(index,number);
    }
    
    public int find(int number) {
        if(!num.containsKey(number)) return -1;
        return num.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */