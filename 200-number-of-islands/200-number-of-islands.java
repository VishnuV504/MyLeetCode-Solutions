class Solution {
    int m,n; int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int ans=0; m=grid.length; n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==49 && visited[i][j]==false){
                    ans++;
                    solve(i,j,grid,visited);
                   // solve(i,j,visited,grid);
                }
            }
        }
        return ans;
    }
    //bfs
    private void solve(int row,int col,char grid[][],boolean visited[][]){
        Queue<int[]>q= new LinkedList<>();
        int arr[]= new int[2]; arr[0]=row;arr[1]=col;
        q.add(arr);
        while(!q.isEmpty()){
            int currRow=q.peek()[0];
            int currCol=q.peek()[1];
            q.remove();
            if(visited[currRow][currCol]==false){
                visited[currRow][currCol]=true;
                for(int i=0;i<4;i++){
                    if(currRow+dir[i][0]<0||currRow+dir[i][0]>=m||currCol+dir[i][1]<0||currCol+dir[i][1]>=n||grid[currRow+dir[i][0]][currCol+dir[i][1]]==48) continue;
                    int arr2[]=new int[2];
                    arr2[0]=currRow+dir[i][0];
                    arr2[1]=currCol+dir[i][1];
                    q.add(arr2);
                }
            }
        }
        return ;
        
    }
    //dfs
    private void solve(int row,int col,boolean visited[][],char grid[][]){
        if(row<0||row>=m||col<0||col>=n||grid[row][col]==48||visited[row][col]==true)return;
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            solve(row+dir[i][0],col+dir[i][1],visited,grid);
        } 
    }
}
