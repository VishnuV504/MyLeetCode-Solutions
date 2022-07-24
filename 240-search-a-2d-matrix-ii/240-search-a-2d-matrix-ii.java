class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length; int n=matrix[0].length;
        int row=m-1; int col=0;
        while(true){
            if(matrix[row][col]==target)return true;
            if(row-1>=0&&target<matrix[row][col]){
                row--;
            }
            else if(col+1<n)col++;
            else return false;
        }
    }
}