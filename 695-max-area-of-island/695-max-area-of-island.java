class Solution {
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;n=grid[0].length; int max=0;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1&&visited[i][j]==false)
                    max=Math.max(solve(i,j,grid,visited),max);
        return max; 
    }
    private int solve(int row,int col,int grid[][],boolean visited[][]){
        if(row<0||row>=m||col<0||col>=n||grid[row][col]==0||visited[row][col])return 0;
            visited[row][col]=true;
        return 1+solve(row-1,col,grid,visited)+solve(row,col-1,grid,visited)+solve(row,col+1,grid,visited)+solve(row+1,col,grid,visited);
    }
}