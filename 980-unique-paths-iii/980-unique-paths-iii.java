class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int totalWays=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    totalWays=solve(i,j,m,n,grid);
                    return totalWays;
                }
                
            }
        }
        return 0;   
    }
    private int solve(int currRow,int currCol,int m,int n,int grid[][])   
    {
        if(currRow<0||currRow>=m||currCol>=n||currCol<0||grid[currRow][currCol]==3||grid[currRow][currCol]==-1)
            return 0;
        if(grid[currRow][currCol]==2)
        {
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]==0)// it mean not visited 
                        return 0;
                }
            }
            return 1;
        }
        int top,down,left,right=0;
        int temp=grid[currRow][currCol];// actually we dont need temp at any way it is zero only
        grid[currRow][currCol]=3;// making it as visited
        left=solve(currRow,currCol-1,m,n,grid);
        right=solve(currRow,currCol+1,m,n,grid);
        top=solve(currRow-1,currCol,m,n,grid);
        down=solve(currRow+1,currCol,m,n,grid);
        grid[currRow][currCol]=temp; // we can directly put as zero becuase we only go through the cells which are zero
        return left+right+top+down;    
    }
}