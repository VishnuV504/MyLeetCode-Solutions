class Solution {
    int dp[][][]= new int[102][102][210];
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==')'||grid[m-1][n-1]=='(') return false;
        for(int i=0;i<=101;i++)
            for(int j=0;j<=101;j++)
                for(int k=0;k<210;k++)
                        dp[i][j][k]=-1;
        return solve(0,0,grid,m,n,0);
    }
    
    private boolean solve(int row,int col,char grid[][],int m, int n,int score)
    {
        if(row>=m||col>=n) return false;
        score=(grid[row][col]=='(')? ++score : --score;
        if(score<0) return false;
        if(row==m-1 && col==n-1)
        {
            if(score==0)
            return true;
            return false;
        }
        if(dp[row][col][score]!=-1) return (dp[row][col][score]==1)? true :false;
        boolean a=solve(row+1,col,grid,m,n,score);
        boolean b=solve(row,col+1,grid,m,n,score); 
        dp[row][col][score]= ((a||b)==true) ? 1:0;
        return a||b;   
    }
}