class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][]= new int[12][amount+1];
        for(int i=0;i<12;i++)
        Arrays.fill(dp[i],-1);
        int ans=(solve(0,coins,amount,dp));
        if(ans>=100000) return -1;
        return ans;
    }
    private int solve(int curr,int coins[],int amount,int dp[][])
    {
        if(amount==0)return 0;
        if(curr>=coins.length||amount<coins[curr]) return 100000;
        if(dp[curr][amount]!=-1)return dp[curr][amount];
        int ans=Integer.MAX_VALUE;
        for(int i=curr;i<coins.length;i++)
            ans=Math.min(ans,1+solve(i,coins,amount-coins[i],dp));
        return dp[curr][amount]=ans;
    }
}