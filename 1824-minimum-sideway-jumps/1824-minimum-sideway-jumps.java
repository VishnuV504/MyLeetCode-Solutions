class Solution {
    public int minSideJumps(int[] obstacles) {
        int n=obstacles.length;
        int dp[][]= new int[3][n+1];
        for(int i=0;i<3;i++)
            Arrays.fill(dp[i],-1);
        int grid[][]= new int[n][3];
        for(int i=0;i<n;i++)
            if(obstacles[i]!=0)
                grid[i][obstacles[i]-1]=1;
        // for(int i=0;i<n;i++)
        //     System.out.println(grid[i][0]+" "+grid[i][1]+" "+grid[i][2]);
        return solve(0,1,n-1,grid,dp); 
    }
    private int solve(int currRow,int currCol,int n,int grid[][],int dp[][])
    {
        if(currRow>=n) return 0;
        if(currCol<0||currCol>=3||grid[currRow][currCol]==1||grid[currRow][currCol]==2) return 1000000;
        if(dp[currCol][currRow]!=-1) return dp[currCol][currRow];
        int l=1000000;int r=1000000;
        grid[currRow][currCol]=2;//visited
        int s=solve(currRow+1,currCol,n,grid,dp);
        if(grid[currRow+1][currCol]==1)
        {
            if(currCol==0)
            {
                l=1+solve(currRow,1,n,grid,dp);
                r=1+solve(currRow,2,n,grid,dp);
            }
            if(currCol==1)
            {
                l=1+solve(currRow,0,n,grid,dp);
                r=1+solve(currRow,2,n,grid,dp);
            }
            if(currCol==2)
            {
                l=1+solve(currRow,1,n,grid,dp);
                r=1+solve(currRow,0,n,grid,dp);
            }
        }
        grid[currRow][currCol]=0;//unvisited backtrack
        return dp[currCol][currRow]=Math.min(s,Math.min(l,r));
    }
}