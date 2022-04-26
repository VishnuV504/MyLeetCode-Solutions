class Solution {
    public int getMaximumGold(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int maxGold=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                maxGold=Math.max(maxGold,solve(i,j,grid,m,n));   
            }
        }
        return maxGold;  
    }
    private int solve(int currRow,int currCol,int grid[][],int m, int n)
    {
        if(currRow<0||currCol<0||currRow>=m||currCol>=n||grid[currRow][currCol]==0) return 0;
        int temp=grid[currRow][currCol]; // storing the value of visited cell
        grid[currRow][currCol]=0;//visited
        int up=temp+solve(currRow-1,currCol,grid,m,n);
        int down=temp+solve(currRow+1,currCol,grid,m,n);
        int left=temp+solve(currRow,currCol-1,grid,m,n);
        int right=temp+solve(currRow,currCol+1,grid,m,n);
        grid[currRow][currCol]=temp; // backtrack
        int max=Math.max(left,Math.max(up,down));
        return Math.max(max,right);
    }
}