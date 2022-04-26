class Solution {
    public int getMaximumGold(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int dp[][] = new int[m][n];
        int maxGold=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                maxGold=Math.max(maxGold,solve(i,j,grid,dp,visited,m,n));   
            }
        }
        return maxGold;  
    }
    private int solve(int currRow,int currCol,int grid[][],int dp[][], boolean visited[][],int m, int n)
    {
        if(currRow<0||currCol<0||currRow>=m||currCol>=n) return 0;
        int up=0;int left=0;int right=0; int down=0;
        if(grid[currRow][currCol]!=0&& visited[currRow][currCol]!=true)
        {
            if(currRow>=0)
            {
                visited[currRow][currCol]=true;
                up=grid[currRow][currCol]+solve(currRow-1,currCol,grid,dp,visited,m,n);
                visited[currRow][currCol]=false;
            }
            if(currRow<m)
            {
                visited[currRow][currCol]=true;
                down=grid[currRow][currCol]+solve(currRow+1,currCol,grid,dp,visited,m,n);
                visited[currRow][currCol]=false;
            }
            if(currCol>=0)
            {
                visited[currRow][currCol]=true;
                left=grid[currRow][currCol]+solve(currRow,currCol-1,grid,dp,visited,m,n);
                visited[currRow][currCol]=false;
            }
            if(currCol<n)
            {
                visited[currRow][currCol]=true;
                right=grid[currRow][currCol]+solve(currRow,currCol+1,grid,dp,visited,m,n);
                visited[currRow][currCol]=false;
            }
        }
        int max=Math.max(left,Math.max(up,down));
        return Math.max(max,right);
    }
}