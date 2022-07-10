class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int dp[]=new int[1001];
        // Arrays.fill(dp,-1);
        // solve(0,cost,dp);
       //return Math.min(dp[0],dp[1]);  
       // return solve(cost);
        return solve2(cost);
    }
    //top down +memo
    private int solve(int curr,int cost[],int dp[]){
        if(curr>=cost.length)return 0;
        if(dp[curr]!=-1)return dp[curr];
            return dp[curr]=cost[curr]+Math.min(solve(curr+1,cost,dp),solve(curr+2,cost,dp));
    }
    //bottom up
    private int solve(int cost[]){
        int dp[]=new  int[1002];
        dp[0]=cost[0]; dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
    //space opti
    private int solve2(int cost[]){
        int prevPrev=cost[0];
        int prev=cost[1]; int curr=0;
        for(int i=2;i<cost.length;i++){
            curr=cost[i]+Math.min(prev,prevPrev);
            prevPrev=prev;
            prev=curr;
        }
        return Math.min(prev,prevPrev);
    }
}