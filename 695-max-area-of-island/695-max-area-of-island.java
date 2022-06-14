class Solution {
    int m; int n;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length; int max=0;
        n=grid[0].length; int visited[][]= new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                max=Math.max(max,solve(i,j,grid,visited));
        return max;  
    }
    private int solve(int i,int j,int[][] grid,int visited[][])
    {
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0||visited[i][j]==1)return 0;
        visited[i][j]=1;
        return 1+solve(i-1,j,grid,visited)+solve(i,j-1,grid,visited)+solve(i,j+1,grid,visited)+solve(i+1,j,grid,visited);
    }

}