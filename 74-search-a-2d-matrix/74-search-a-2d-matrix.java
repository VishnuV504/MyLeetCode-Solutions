class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m= matrix.length;
        int n = matrix[0].length;
            int j=0; int k=m*n-1;
            while(j<=k)
            {
                int mid= j+(k-j)/2;
                //System.out.println(matrix[(mid/n)][mid%n]);
                if(matrix[(mid/n)][mid%n]==target)
                    return true;
                else if(matrix[(mid/n)][mid%n]>target)
                    k=mid-1;
                else
                    j=mid+1;
            }
        return false;
    }
}