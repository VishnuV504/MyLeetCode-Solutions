class Solution {
    int M,n; long m=1000000007;
    public int maxProductPath(int[][] grid) {
        M=grid.length; n=grid[0].length;
        return solve(grid);
        
    }    
    private int solve(int grid[][]){
        long minDp[][]=new long[M][n]; long maxDp[][]=new long[M][n];
        minDp[0][0]=grid[0][0];
        maxDp[0][0]=grid[0][0];
        //base case
        for(int i=1;i<n;i++){
            minDp[0][i]=minDp[0][i-1]*grid[0][i];
            maxDp[0][i]=maxDp[0][i-1]*grid[0][i];
        }
        for(int i=1;i<M;i++){
            minDp[i][0]=minDp[i-1][0]*grid[i][0];
            maxDp[i][0]=maxDp[i-1][0]*grid[i][0];
        }
        
        for(int i=1;i<M;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]>0){
                    maxDp[i][j] = Math.max(maxDp[i-1][j]*grid[i][j],maxDp[i][j-1]*grid[i][j]);
				    minDp[i][j] = Math.min(minDp[i-1][j]*grid[i][j],minDp[i][j-1]*grid[i][j]);
                }
                else{
                    maxDp[i][j] = Math.max(minDp[i-1][j]*grid[i][j],minDp[i][j-1]*grid[i][j]);
				    minDp[i][j] = Math.min(maxDp[i-1][j]*grid[i][j],maxDp[i][j-1]*grid[i][j]);
                }
            }
        }
        int ans=(int)((maxDp[M-1][n-1])%m);
        return ans<0?-1:ans;
    }
}