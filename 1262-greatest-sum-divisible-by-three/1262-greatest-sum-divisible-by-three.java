class Solution {
    HashMap<String,Integer>dp = new HashMap<>();
    public int maxSumDivThree(int[] nums) {
        int n= nums.length;
        return solve(0,n,nums,0);
    }
    private int solve(int curr, int n ,int nums[],int sum)
    {
        if(curr==n)
        {
            if(sum==0)
            return 0;
            return -10000;
        }
        String currKey=curr+"-"+sum;
        if(dp.containsKey(currKey)) return dp.get(currKey);
      dp.put(currKey,Math.max(nums[curr]+solve(curr+1,n,nums,(sum+nums[curr])%3),solve(curr+1,n,nums,sum)));
        return dp.get(currKey);
    }
}