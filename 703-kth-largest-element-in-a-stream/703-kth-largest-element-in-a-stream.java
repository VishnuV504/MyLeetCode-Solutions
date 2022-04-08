class KthLargest {
        PriorityQueue<Integer>p = new PriorityQueue<>();
        int K=0;
    public KthLargest(int k, int[] nums) {
        K=k;
        for(int i=0;i<nums.length;i++)
        {
            if(p.size()<k)
                p.add(nums[i]);
            else
            {
                if(nums[i]>p.peek())
                {
                    p.remove();
                    p.add(nums[i]);
                }
            }
        }   
    }
    
    public int add(int val) {
        if(p.size()<K)
                p.add(val);
        else if(val>p.peek())
        {
            p.remove();
            p.add(val);
        }
        return p.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */