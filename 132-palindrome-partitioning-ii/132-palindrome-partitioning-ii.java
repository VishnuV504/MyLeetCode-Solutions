class Solution {
    private boolean isPalindrome(int low, int high, String s)
    {
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
    
    public int minCut(String s) {
        int dp[]= new int[2001];
        Arrays.fill(dp,-1);
            return minCuts(0,s.length()-1,s,dp);
    }
    
    private int minCuts(int low,int high,String s,int dp[])
    {
        if(isPalindrome(low,high,s))
            return 0;
        if(dp[low]!=-1)
            return dp[low];
        int ans= Integer.MAX_VALUE;
        for(int i=low;i<high;i++)
        {
            if(isPalindrome(low,i,s))
            {
               int left = 1+minCuts(i+1,high,s,dp);
                ans=Math.min(left,ans);
            }
            
        }
        dp[low]=ans;
        return ans;
    }
}