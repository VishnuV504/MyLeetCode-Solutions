class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]= new int[501][501];
        for(int i=0;i<501;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,0,word1,word2,dp);  
    }
    private int solve(int i,int j,String word1,String word2,int dp[][])
    {
        if(i==word1.length())
            return word2.length()-j;
        if(j==word2.length())
            return word1.length()-i;
        if(dp[i][j]!=-1)return dp[i][j];
        int a=Integer.MAX_VALUE;
        if(word1.charAt(i)==word2.charAt(j))
             a=solve(i+1,j+1,word1,word2,dp);
        int b=1+Math.min(solve(i+1,j,word1,word2,dp),solve(i,j+1,word1,word2,dp));
        return dp[i][j]=Math.min(a,b);     
    }
}