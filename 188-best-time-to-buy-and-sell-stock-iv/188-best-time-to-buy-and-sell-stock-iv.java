class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[2][k+1][prices.length+1];
        for(int i=0;i<2;i++)
            for(int j=0;j<=k;j++)
                for(int l=0;l<=prices.length;l++)
                    dp[i][j][l]=-10000;
        return profit(0,k,prices,1,dp);
        
    }
    private int profit(int curr, int k, int prices[], int canBuy,int dp[][][])
    {
        if(curr==prices.length||k==0)
            return 0;
        if(dp[canBuy][k][curr]!=-10000)
            return dp[canBuy][k][curr];
        int idle = profit(curr+1,k,prices,canBuy,dp);
        int buy=0; int sell=0;
        if(canBuy==1)
            buy=-prices[curr]+profit(curr+1,k,prices,0,dp);
        else
            sell=prices[curr]+profit(curr+1,k-1,prices,1,dp);
        dp[canBuy][k][curr]=Math.max(idle,Math.max(buy,sell));
        return  dp[canBuy][k][curr];
            
        
    }
}