class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[2][2][prices.length+1];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                for(int k=0;k<=prices.length;k++)
                    dp[i][j][k]=-100000;
        return max(0,prices,1,1,dp);
        
    }
    private int max(int curr,int prices[],int flag,int k,int dp[][][])
    {
        if(curr==prices.length|| k==0)
            return 0;
        int buy=0;
        int sell=0;
        if(dp[k][flag][curr]!=-100000)
            return dp[k][flag][curr];
        int idle = max(curr+1,prices,flag,k,dp);
        if(flag==1)
            buy=-prices[curr]+max(curr+1,prices,0,k,dp);
        else
        {
            sell = prices[curr]+max(curr+1,prices,1,k-1,dp);
        }
        dp[k][flag][curr]=Math.max(idle,Math.max(buy,sell));
        return dp[k][flag][curr];
            
    }
}