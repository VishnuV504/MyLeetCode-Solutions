class Solution {
    Boolean dp[][][]= new Boolean[102][102][210];
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==')'||grid[m-1][n-1]=='(') return false;
        return solve(0,0,grid,m,n,0);
    }
    private boolean solve(int row,int col,char grid[][],int m,int n,int score)
    {
        if(row>=m||col>=n) return false;
        score=(grid[row][col]=='(')? ++score : --score;
        if(score<0) return false;
        if(row==m-1 && col==n-1)
        return score==0;
        if(dp[row][col][score]!=null) return dp[row][col][score];
        return dp[row][col][score]=solve(row+1,col,grid,m,n,score)||solve(row,col+1,grid,m,n,score);  
    }
}