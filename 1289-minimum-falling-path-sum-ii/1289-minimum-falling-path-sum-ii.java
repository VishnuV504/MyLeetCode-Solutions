class Solution {
    // i just need to track of 2 prevmin's and i will check if the firstprevmin is above current index if it is i will take prevsecondmin  if not i will select firstmin (if i take everytime min that is my minimum falling path naa? by following above conditions)
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int dp[][]= new int [n][n];
        int prevfirstMin=Integer.MAX_VALUE; int prevsecondMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(matrix[0][i]<prevfirstMin)
            {
                int temp= prevfirstMin;
                prevfirstMin=matrix[0][i];
                prevsecondMin=temp;
            }
            else if(matrix[0][i]<=prevsecondMin)
                prevsecondMin=matrix[0][i];
            dp[0][i]=matrix[0][i]; 
        }  
        //System.out.println(prevfirstMin +" "+prevsecondMin);
        
        for(int i=1;i<n;i++)
        {
            int firstMin=Integer.MAX_VALUE; int secondMin=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                    if(prevfirstMin==dp[i-1][j])
                    dp[i][j]=matrix[i][j]+prevsecondMin;
                    else
                    dp[i][j]=matrix[i][j]+prevfirstMin;
                    
                
                if(dp[i][j]<firstMin)
                {
                    int temp= firstMin;
                    firstMin=dp[i][j];
                    secondMin=temp;
                }
                else if(dp[i][j]<=secondMin)
                    secondMin=dp[i][j];

            }
            prevfirstMin=firstMin;
            prevsecondMin=secondMin;
           // System.out.println(prevfirstMin +" "+prevsecondMin);
        }
        int overAllMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(dp[n-1][i]<overAllMin)
                overAllMin=dp[n-1][i];
        }
        return overAllMin;
        
    }
}