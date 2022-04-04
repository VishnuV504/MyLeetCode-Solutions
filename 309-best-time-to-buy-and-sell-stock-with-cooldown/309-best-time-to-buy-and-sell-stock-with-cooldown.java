class Solution {
    public int maxProfit(int[] prices) {
        // infinite transactions allowed so remove transaction count
        int dp[][] = new int[2][prices.length+1];
        for(int i=0;i<2;i++)
                for(int l=0;l<=prices.length;l++)
                    dp[i][l]=-10000;
        return profit(0,prices,1,dp);
        
    }
    private int profit(int curr,int prices[], int canBuy,int dp[][])
    {
        if(curr>=prices.length)
            return 0;
        if(dp[canBuy][curr]!=-10000)
            return dp[canBuy][curr];
        int idle = profit(curr+1,prices,canBuy,dp);
        int buy=0; int sell=0;
        if(canBuy==1)
            buy=-prices[curr]+profit(curr+1,prices,0,dp);
        else
            sell=prices[curr]+profit(curr+2,prices,1,dp);
        dp[canBuy][curr]=Math.max(idle,Math.max(buy,sell));
        return  dp[canBuy][curr];
            
        
    }
}