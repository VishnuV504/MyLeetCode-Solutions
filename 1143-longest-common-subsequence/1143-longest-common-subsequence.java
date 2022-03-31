class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[1000][1001];
        for(int i=0;i<1000;i++)
        Arrays.fill(dp[i],-1);
        return lcs(0,0,text1,text2,dp);
        
    }
    private int lcs(int curr1, int curr2,String s1, String s2,int dp[][])
    {
        if(curr1==s1.length()||curr2==s2.length())
            return 0;
        if(dp[curr1][curr2]!=-1)
            return dp[curr1][curr2];
        int ans=0;
        if(s1.charAt(curr1)==s2.charAt(curr2))
            ans=1+lcs(curr1+1,curr2+1,s1,s2,dp);
        else
        {
            int moveCurr1=lcs(curr1+1,curr2,s1,s2,dp);
            int moveCurr2=lcs(curr1,curr2+1,s1,s2,dp);
            ans=Math.max(moveCurr1,moveCurr2);
        }
        dp[curr1][curr2]=ans;
        return dp[curr1][curr2];
    }
}