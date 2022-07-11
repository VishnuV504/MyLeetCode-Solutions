class SmallestInfiniteSet {
    Set<Integer>s= new TreeSet<>();
    int curr=1;
    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        if(!s.isEmpty()){
            int smallest=s.iterator().next();
            s.remove(smallest);
            return smallest;
        }
        else{
            curr++;
            return curr-1;
        }
    }
    
    public void addBack(int num) {
        if(num<curr)s.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */