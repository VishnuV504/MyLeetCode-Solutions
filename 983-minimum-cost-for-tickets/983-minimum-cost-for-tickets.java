class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][] = new int[days.length][days[days.length-1]+31];
        for(int i=0;i<days.length;i++)
            Arrays.fill(dp[i],-1);
        return minCost(0,days,costs,0,dp);
        
    }
    private int minCost(int curr,int days[],int cost[],int prev,int dp[][])
    {
        if(curr==days.length)
            return 0;
        int oneDay=1000; int svnDay=1000; int thirDay=1000;
        if(dp[curr][prev]!=-1)
            return dp[curr][prev];
        if(days[curr]>prev)
        {
            oneDay=cost[0]+minCost(curr+1,days,cost,days[curr],dp);
            svnDay=cost[1]+minCost(curr+1,days,cost,days[curr]+6,dp);
            thirDay=cost[2]+minCost(curr+1,days,cost,days[curr]+29,dp);
        }
        else
        {
            dp[curr][prev]= minCost(curr+1,days,cost,prev,dp);
            return dp[curr][prev];
        }
        dp[curr][prev]=Math.min(oneDay,Math.min(svnDay,thirDay));
        return dp[curr][prev];
    }
}