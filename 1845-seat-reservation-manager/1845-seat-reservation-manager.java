class SeatManager {
    TreeSet<Integer>t = new TreeSet<>();
    public SeatManager(int n) {
        for(int i=1;i<=n;i++)
            t.add(i);
    }
    
    public int reserve() {
       int ans= t.first();
        t.remove(ans);
        return ans;
    }
    
    public void unreserve(int seatNumber) {
        t.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */