class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[10001];
        Arrays.fill(dp,-1);
       return minJumps(0,nums,dp);
        
    }
    private int minJumps(int curr, int nums[],int dp[])
    {
        if(curr==nums.length-1)
            return 0;
        if(curr>nums.length)
            return 10001;
        if(dp[curr]!=-1)
            return dp[curr];
        int pick=10001;
        int ans=10001;
        for(int i=1;i<=nums[curr];i++)
        {
            if(curr+i<nums.length)
            {
             pick=1+minJumps(curr+i,nums,dp);
            ans=Math.min(ans,pick);
            }
        }
        dp[curr]=ans;
        return ans;
    }
}