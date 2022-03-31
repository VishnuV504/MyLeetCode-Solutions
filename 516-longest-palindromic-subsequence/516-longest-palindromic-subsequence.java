class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[1000][1001];
        for(int i=0;i<1000;i++)
        Arrays.fill(dp[i],-1);
        return lps(0,s.length()-1,s,dp); 
    }
    private int lps(int start, int end,String s,int dp[][])
    {
        if(start==end)
            return 1;
        if(start>end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        int ans=0;
        if(s.charAt(start)==s.charAt(end))
        {
          ans= 2+lps(start+1,end-1,s,dp);
        }
        else
        {
            int moveStart=lps(start+1,end,s,dp);
            int moveEnd=lps(start,end-1,s,dp);
            ans=Math.max(moveStart,moveEnd);
        }
        dp[start][end]=ans;
        return ans;
    }
}