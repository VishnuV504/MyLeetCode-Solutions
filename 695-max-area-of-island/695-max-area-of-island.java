class Solution {
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;n=grid[0].length; int max=0;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1&&visited[i][j]==false)
                    max=Math.max(max,solve2(i,j,grid,visited));
        return max; 
    }
    private int solve(int row,int col,int grid[][],boolean visited[][]){
        if(row<0||row>=m||col<0||col>=n||grid[row][col]==0||visited[row][col])return 0;
            visited[row][col]=true;
        return 1+solve(row-1,col,grid,visited)+solve(row,col-1,grid,visited)+solve(row,col+1,grid,visited)+solve(row+1,col,grid,visited);
    }
    
    private int solve2(int row,int col,int grid[][],boolean visited[][]){
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>q= new LinkedList<>();
        int arr[]=new int[2]; int count=0;
        arr[0]=row; arr[1]=col; q.add(arr);
        while(!q.isEmpty()){
            int currRow=q.peek()[0];
            int currCol=q.peek()[1];
            q.remove();
            if(visited[currRow][currCol]==false){
                visited[currRow][currCol]=true;
                count++;
                for(int i=0;i<4;i++){
                    if(currRow+dir[i][0]<0||currRow+dir[i][0]>=m||currCol+dir[i][1]<0||currCol+dir[i][1]>=n||grid[currRow+dir[i][0]][currCol+dir[i][1]]==0) continue;
                    int arr2[]=new int[2];
                    arr2[0]=currRow+dir[i][0];
                    arr2[1]=currCol+dir[i][1];
                    q.add(arr2);
                }
            }
        }
        return count;
        
    }
}