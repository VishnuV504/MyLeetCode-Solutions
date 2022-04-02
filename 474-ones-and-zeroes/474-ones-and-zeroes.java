class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int countOnes[]=new int[strs.length];
        int countZeros[]= new int[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            int count1=0;
            int count0=0;
            for(int j=0;j<strs[i].length();j++)
            {
                if(strs[i].charAt(j)=='1')
                    count1++;
                else
                    count0++;
            }
            countOnes[i]=count1;
            countZeros[i]=count0;
            //System.out.println(countOnes[i] +" "+countZeros[i]);
        }
        int dp[][][] = new int[m+1][n+1][strs.length]; 
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                for(int k=0;k<strs.length;k++)
                    dp[i][j][k]=-1;
        return maxLength(0,0,0,m,n,countOnes,countZeros,dp);
        
    }
    private int maxLength(int curr,int count1,int count0,int m, int n, int ones[],int zeros[],int dp[][][])
    {
        if(count1>n ||count0>m)
            return 0;
        if(curr>=ones.length)
            return 0;
        if(dp[count0][count1][curr]!=-1)
            return dp[count0][count1][curr];
        int consider=0;
        if(ones[curr]<=n-count1 && zeros[curr]<=m-count0)
        consider=1+maxLength(curr+1,count1+ones[curr],count0+zeros[curr],m,n,ones,zeros,dp);
        int notConsider=maxLength(curr+1,count1,count0,m,n,ones,zeros,dp);
        dp[count0][count1][curr]=Math.max(consider,notConsider);
        return dp[count0][count1][curr]; 
        
    }
}