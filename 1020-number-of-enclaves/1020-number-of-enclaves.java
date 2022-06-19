class Solution {
    int m; int n; int count=0;
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length; boolean visited[][]= new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0) count++;
                else if(grid[i][j]==1&&visited[i][j]==false&&(i==0||i==m-1||j==0||j==n-1))
                {
                    bfs(i,j,grid,visited);
                }
            }
        }
        return m*n-count;   
    }
    private void bfs(int row,int col,int grid[][],boolean visited[][])
    {
        Queue<int[]>q=new LinkedList<>();
        int arr[]={row,col};
        q.add(arr);visited[row][col]=true;
        while(!q.isEmpty())
        {
            row=q.peek()[0];
            col=q.peek()[1];
            q.remove();
            count++;
            if(row-1>=0&&grid[row-1][col]==1&&visited[row-1][col]==false)
            {int arr2[]={row-1,col};q.add(arr2);visited[row-1][col]=true;}
            if(col-1>=0&&grid[row][col-1]==1&&visited[row][col-1]==false)
            {int arr2[]={row,col-1};q.add(arr2);visited[row][col-1]=true;}
            if(col+1<n&&grid[row][col+1]==1&&visited[row][col+1]==false)
            {int arr2[]={row,col+1};q.add(arr2);visited[row][col+1]=true;}
            if(row+1<m&&grid[row+1][col]==1&&visited[row+1][col]==false)
            {int arr2[]={row+1,col};q.add(arr2);visited[row+1][col]=true;}
        }

    }
}