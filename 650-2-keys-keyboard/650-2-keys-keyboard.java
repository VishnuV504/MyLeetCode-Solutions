class Solution {
    public int minSteps(int n) {
        if(n==1)
            return 0;
        int dp[][][]=new int[n][n][2];
        return 1+fewSteps(1,n,1,0,dp);  // 1+ is for because first time copy should be done 
        
    }
    private int fewSteps(int curr, int n,int prevCopied,int flag,int dp[][][])
    {
        if(curr==n)
            return 0;
        if(curr>n)
            return 10000;
        if(dp[curr][prevCopied][flag]!=0)
            return dp[curr][prevCopied][flag];
        int copy=10000;
        int paste=10000;
        if(flag==0)
            copy=1+fewSteps(curr,n,curr,1,dp);
        paste = 1+fewSteps(curr+prevCopied,n,prevCopied,0,dp);
        dp[curr][prevCopied][flag]=Math.min(copy,paste);
        return dp[curr][prevCopied][flag];
    }
}