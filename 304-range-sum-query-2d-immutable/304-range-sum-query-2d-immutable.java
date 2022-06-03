class NumMatrix {
    int hs1[][];
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length; 
        hs1=new int[m][n];
        for(int i=0;i<m;i++)
        {
            int prefixSum=0;
            for(int j=0;j<n;j++)
            {
                prefixSum=matrix[i][j];
                prefixSum+=(j>0)?hs1[i][j-1]:0;
                hs1[i][j]=prefixSum;
            }
        } 
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1;i<=row2;i++)
        {
            ans+=hs1[i][col2];
            ans-=(col1>0)?hs1[i][col1-1]:0;
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */