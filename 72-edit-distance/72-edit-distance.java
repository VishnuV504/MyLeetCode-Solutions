class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[500][501];
        for(int i=0;i<500;i++)
            Arrays.fill(dp[i],-1);
        return minOperations(0,0,word1,word2,dp);
        
    }
    private int minOperations(int currS1,int currS2,String s1, String s2,int dp[][])
    {
        if(currS1==s1.length())
            return s2.length()-currS2;
        if(currS2==s2.length())
            return s1.length()-currS1;
        if(dp[currS1][currS2]!=-1)
            return dp[currS1][currS2];
        int ans=0;
        if(s1.charAt(currS1)==s2.charAt(currS2))
            ans=minOperations(currS1+1,currS2+1,s1,s2,dp);
        else
        {
            int insert=1+minOperations(currS1,currS2+1,s1,s2,dp);
            int replace= 1+minOperations(currS1+1,currS2+1,s1,s2,dp);
            int delete = 1+minOperations(currS1+1,currS2,s1,s2,dp);
            ans=Math.min(insert,Math.min(replace,delete));
        }
        dp[currS1][currS2]=ans;
        return ans;
    }
}