class Solution {
    int m,n,k; 
    int dp[][]=new int[70][5000];
    public int minimizeTheDifference(int[][] mat, int target) {
         m=mat.length; n=mat[0].length;
        k=target;
        for(int i=0;i<70;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,mat,0);
        
    }
    private int solve(int currRow,int mat[][],int l){
        if(currRow==m) return Math.abs(k-l);
        if(dp[currRow][l]!=-1)return dp[currRow][l];
       int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
           min=Math.min(min,solve(currRow+1,mat,l+mat[currRow][i]));
        return dp[currRow][l]=min;
    }
}