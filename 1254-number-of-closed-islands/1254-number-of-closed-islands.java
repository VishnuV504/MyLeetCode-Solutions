class Solution {
    int m,n; int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public int closedIsland(int[][] grid) {
        int ans=0; m=grid.length; n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&visited[i][j]==false){
                   if(solve(i,j,visited,grid)){
                       ans++;
                   }
                }
            }
        }
        return ans;
    }
    private boolean solve(int row,int col,boolean visited[][],int grid[][]){
        if(row<0||row>=m||col<0||col>=n)return false;
        if(grid[row][col]==1||visited[row][col]==true) return true;
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            if(solve(row+dir[i][0],col+dir[i][1],visited,grid)==false){
                visited[row][col]=false; 
                return false;
            }
        } 
        return true;
    }

}