class NumberContainers {
    HashMap<Integer,Integer>idx=new HashMap<>();
    HashMap<Integer,PriorityQueue<Integer>>num= new HashMap<>();
    public NumberContainers() {
        return ;
    }
    
    public void change(int index, int number) {
        if(num.containsKey(number)){
            num.get(number).add(index);
        }
        else{
            PriorityQueue<Integer>pq= new PriorityQueue<>();
            pq.add(index);
            num.put(number,pq);
        }
        idx.put(index,number);
    }
    
    public int find(int number) {
        if(!num.containsKey(number)) return -1;
        while(!(num.get(number).isEmpty())){
            int n=idx.get(num.get(number).peek());
            if(n==number)return num.get(number).peek();
            num.get(number).poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */