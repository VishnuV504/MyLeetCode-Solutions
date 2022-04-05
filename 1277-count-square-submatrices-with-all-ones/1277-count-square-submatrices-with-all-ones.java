class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        HashMap<String,Integer>memo = new HashMap<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                count+= maxArea(i,j,matrix.length,matrix[i].length,matrix,memo);
            }
        }
        return count;    
    }
    private int maxArea(int currRow,int currCol,int rows, int cols,int matrix[][],HashMap<String,Integer>memo)
    {
        if(currRow>=rows|| currCol>=cols||matrix[currRow][currCol]==0)
            return 0;
        String currKey = Integer.toString(currRow)+"-"+Integer.toString(currCol);
        if(memo.containsKey(currKey))
            return memo.get(currKey);
        int right=1+maxArea(currRow,currCol+1,rows,cols,matrix,memo);
        int down=1+maxArea(currRow+1,currCol,rows,cols,matrix,memo);
        int diagnol=1+maxArea(currRow+1,currCol+1,rows,cols,matrix,memo);
        memo.put(currKey,Math.min(right,Math.min(down,diagnol)));
        return memo.get(currKey);
        
    }
}