class Solution {
    public int totalNQueens(int n) {
        int board[][]= new int[n][n];
        int colMask=0;
        return solve(0,board,n,colMask);    
    }
    private int solve(int row,int grid[][],int n,int colMask)
    {
        if(row==n)
            return 1;
        int totalWays=0;
        for(int i=0;i<n;i++)
        {
            if((colMask&(1<<i))!=0) continue;
            if(isValid(grid,row,i,n)==true)
            {
                grid[row][i]=1;
                colMask|=1<<i;
                totalWays+=solve(row+1,grid,n,colMask);
                colMask^=1<<i;
                grid[row][i]=0;
            }
        }
        return totalWays;
    }
    private boolean isValid(int grid[][],int row,int col,int n)// check diagnol
    {
        int a=col+1;
        for(int i=row-1;i>=0;i--)
        {
            if(a<n &&grid[i][a]==1) return false;
            a++;
        }
        a=col-1;
        for(int i=row-1;i>=0;i--)
        {
            if(a>=0&&grid[i][a]==1) return false;
            a--;
        }
        return true;
    }
}