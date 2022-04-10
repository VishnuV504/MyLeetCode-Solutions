class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
            minHeap.add(nums[i]);
        while(k!=0)
        {
            int num=minHeap.poll();
            minHeap.add(num+1);
            k--;
        }
        long product=1;
        int mod=1000000007;
        while(minHeap.size()!=0)
        {
            int num=minHeap.poll();
            product=((product%mod)*(num%mod))%mod;
        }
        return (int)product;
        
    }
}