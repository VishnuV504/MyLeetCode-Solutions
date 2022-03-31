class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int col= matrix[0].length;
        HashMap<String,Integer>memo = new HashMap<>();
        int maxArea=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
               int areaAtCurrIndex=findMaxArea(i,j,matrix,memo);
                maxArea= Math.max(maxArea,areaAtCurrIndex);
            }
        }
        return maxArea*maxArea;
    }
    private int findMaxArea(int currRow,int currCol,char matrix[][],HashMap<String,Integer>memo)
    {
        if(currRow>=matrix.length||currCol>=matrix[0].length||currCol<0)
            return 0;
        String currKey = Integer.toString(currRow)+"-"+Integer.toString(currCol);
        if(memo.containsKey(currKey))
            return memo.get(currKey);
        int right =0;
        int bottom =0;
        int diagnol=0;
        if(matrix[currRow][currCol]=='1')
        {
            right=1+findMaxArea(currRow,currCol+1,matrix,memo);
            bottom=1+findMaxArea(currRow+1,currCol,matrix,memo);
            diagnol=1+findMaxArea(currRow+1,currCol+1,matrix,memo);
        }
        memo.put(currKey,Math.min(right,Math.min(bottom,diagnol)));
        return memo.get(currKey);
    }
}