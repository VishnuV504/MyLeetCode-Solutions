class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]>target || matrix[i][matrix[i].length-1]<target)
                continue;
            int j=0; int k=matrix[i].length-1;
            while(j<=k)
            {
                int mid= j+(k-j)/2;
                if(matrix[i][mid]==target)
                    return true;
                else if(matrix[i][mid]>target)
                    k=mid-1;
                else
                    j=mid+1;
            }
        }
        return false;
    }
}