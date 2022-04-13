class Solution {
    public int countSubstrings(String s) {
        int count=0; int dp[][] = new int[s.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++)
            Arrays.fill(dp[i],-1);
        for(int i=0;i<s.length();i++)
            count+=totalPalin(i,i,s,dp);
        return count;
    }
    private int totalPalin(int index,int curr,String s,int dp[][])
    {
        if(curr>=s.length())
            return 0;
        if(dp[index][curr]!=-1)
            return dp[index][curr];
        if(checkPalin(index,curr,s))
            return dp[index][curr]=1+totalPalin(index,curr+1,s,dp);
        return dp[index][curr]=totalPalin(index,curr+1,s,dp);
    }
    private boolean checkPalin(int i,int j,String s)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}