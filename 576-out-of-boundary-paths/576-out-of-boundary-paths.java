class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][]= new int[m+1][n+1][maxMove+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                for(int k=0;k<=maxMove;k++)
                    dp[i][j][k]=-1;
        return totalWays(m,n,startRow,startColumn,maxMove,0,dp);
        
    }
    private int totalWays(int m, int n,int currRow,int currCol,int maxMove,int moves,int dp[][][])
    {
        int mod=1000000007;
        if(currRow<0||currCol<0||currRow>=m ||currCol>=n)
        {
            if(moves<=maxMove)
            return 1;
            return 0;
        }
        else if(moves>=maxMove)
            return 0;
        else if(dp[currRow][currCol][moves]!=-1)
            return dp[currRow][currCol][moves];
        int top=totalWays(m,n,currRow-1,currCol,maxMove,moves+1,dp);
        int bottom=totalWays(m,n,currRow+1,currCol,maxMove,moves+1,dp);
        int left=totalWays(m,n,currRow,currCol-1,maxMove,moves+1,dp);
        int right=totalWays(m,n,currRow,currCol+1,maxMove,moves+1,dp);
        dp[currRow][currCol][moves]=(((top%mod+bottom%mod)%mod)%mod+((left%mod+right%mod)%mod)%mod)%mod;
        return dp[currRow][currCol][moves];
    }
}