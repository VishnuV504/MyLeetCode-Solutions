class Solution {
    // nth catalan number = sigma 1 to n-1  Ci* Cn-i-1;
    public int catalanNumber(int n, int dp[])
    {
        if(n==0 || n==1)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanNumber(i,dp)*catalanNumber(n-i-1,dp);
        }
        dp[n]=ans;
        return ans;
        
    }
    public int numTrees(int n) {
        int dp[] = new int[20];
        return catalanNumber(n,dp);
        
    }
}