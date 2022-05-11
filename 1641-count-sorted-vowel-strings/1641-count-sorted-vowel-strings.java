class Solution {
    int dp[][] = new int[5][51];
    public int countVowelStrings(int n) {
        for(int i=0;i<5;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,n,0); 
    }
    private int solve(int curr,int n,int len)
    {
        if(len==n) return 1;
        if(dp[curr][len]!=-1) return dp[curr][len];
        int ans=0;
        for(int i=curr;i<=4;i++)
        {
            ans+=solve(i,n,len+1);
        }
        return dp[curr][len]=ans;
    }
}