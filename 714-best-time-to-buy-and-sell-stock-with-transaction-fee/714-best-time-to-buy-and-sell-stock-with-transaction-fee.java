class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[2][prices.length+1];
        for(int i=0;i<2;i++)
                for(int l=0;l<=prices.length;l++)
                    dp[i][l]=-10000;
        return profit(0,prices,1,dp,fee);
        
    }
    private int profit(int curr,int prices[], int canBuy,int dp[][],int fee)
    {
        if(curr==prices.length)
            return 0;
        if(dp[canBuy][curr]!=-10000)
            return dp[canBuy][curr];
        int idle = profit(curr+1,prices,canBuy,dp,fee);
        int buy=0; int sell=0;
        if(canBuy==1)
            buy=-prices[curr]+profit(curr+1,prices,0,dp,fee);
        else
            sell=prices[curr]-fee+profit(curr+1,prices,1,dp,fee);
        dp[canBuy][curr]=Math.max(idle,Math.max(buy,sell));
        return  dp[canBuy][curr];
            
        
    }
}