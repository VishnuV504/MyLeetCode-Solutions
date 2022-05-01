class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        long total=(long)Math.pow(2,maximumBit)-1;
        int n=nums.length;
        int pre[] = new int[n];
        pre[n-1]=nums[0];
        for(int i=1;i<n;i++)
            pre[n-i-1]=nums[i]^pre[n-i];
        int ans[] = new int[n];
        for(int i=0;i<n;i++)
            ans[i]=(int)total-pre[i];
        return ans;
            
        
    }
}