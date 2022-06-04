class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int dp[]= new int[1001];
        Arrays.fill(dp,-1);
       return  solve(nums,target,dp);
    }
    
    private int solve(int nums[],int target,int dp[])
    {
        if(target==0)
        return 1;
        if(target<0) return 0;
        if(dp[target]!=-1) return dp[target];
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>target) break;
            res+=solve(nums,target-nums[i],dp);
        }
        return dp[target]=res;
    }
}