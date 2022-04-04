class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] =new int[nums.length+1][20002];
        for(int i=0;i<=nums.length;i++)
            Arrays.fill(dp[i],-1);
        return maxLength(0,nums,-10001,dp);
    }
    private int maxLength(int curr, int arr[],int prev,int dp[][])
    {
        if(curr==arr.length)
            return 0;
        if(dp[curr][prev+10001]!=-1)
            return dp[curr][prev+10001];
        int consider =-10001;
        if(arr[curr]>prev)
            consider=1+maxLength(curr+1,arr,arr[curr],dp);
        int notConsider=maxLength(curr+1,arr,prev,dp);
        dp[curr][prev+10001]=Math.max(consider,notConsider);
        return dp[curr][prev+10001];
    }
}