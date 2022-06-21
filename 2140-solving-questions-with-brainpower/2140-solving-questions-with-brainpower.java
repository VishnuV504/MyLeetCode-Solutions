class Solution {
    public long mostPoints(int[][] questions) {
        long dp[]= new long[100001];
        Arrays.fill(dp,-1);
        return solve(0,questions,dp);
    }
    private long solve(int curr,int arr[][],long[] dp)
    {
        if(curr>=arr.length) return 0;
        if(dp[curr]!=-1) return dp[curr];
        long cons=(long)arr[curr][0]+solve(curr+arr[curr][1]+1,arr,dp);
        long notCons=solve(curr+1,arr,dp);
        return dp[curr]=Math.max(cons,notCons);
    }
}