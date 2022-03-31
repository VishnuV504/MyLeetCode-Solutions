class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][1001];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
        return totalWays(0,n,k,target,dp);
        
    }
    private int totalWays(int diceNum,int totalDice,int faces,int target,int dp[][])
    {
        if(diceNum==totalDice)
        {
            if(target==0)
                return 1;
            else
                return 0;
        }
        if(target<=0)
            return 0;
        if(dp[diceNum][target]!=-1)
            return dp[diceNum][target];
        
        int ans=0;
        int mod=1000000007;
        for(int i=1;i<=faces;i++)
        {
           ans=((ans%mod) +(totalWays(diceNum+1,totalDice,faces,target-i,dp))%mod)%mod;
        }
        dp[diceNum][target]=ans;
        return ans;
    }
}