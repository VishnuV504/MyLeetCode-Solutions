class Solution {
    int maxLength=0;
    int dir[][]= {{-1,0},{0,-1},{0,1},{1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;
        //HashMap<String,Integer>dp = new HashMap<>();
        int dp[][]= new int[m][n];
        // for(int i=0;i<=m;i++)
        //     Arrays.fill(dp[i],-1);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                maxLength=Math.max(maxLength,solve(i,j,matrix,-1,m,n,dp));
        return maxLength;    
    }
    private int solve(int i,int j, int matrix[][],int prev,int m,int n,int[][] dp)
    {
        if(i<0||j<0||i>=m||j>=n||matrix[i][j]<=prev) return 0;
       // String currKey= i+"-"+j;
        //if(dp.containsKey(currKey)) return dp.get(currKey);
        int len=0;
        if(dp[i][j]!=0) return dp[i][j];
        for(int l=0;l<4;l++)
        len=Math.max(len,1+solve(i+dir[l][0],j+dir[l][1],matrix,matrix[i][j],m,n,dp));
        //dp.put(currKey,len);
        dp[i][j]=len;
        return len;
    }
}