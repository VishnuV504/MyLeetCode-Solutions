class Solution {
    int dp[][] =new int[1002][1002];
    public int numDistinct(String s, String t) {
       for(int i=0;i<1002;i++)
            Arrays.fill(dp[i],-1);
        return  solve(0,0,s,t);
    }
    private int solve(int i,int j, String s, String t)
    {
        if(i==s.length() && j==t.length())
            return 1;
        if(i>=s.length())
            return 0;
        if(j>=t.length())
            return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int a=0;
        if(s.charAt(i)==t.charAt(j))
           a=solve(i+1,j+1,s,t);
        int b=solve(i+1,j,s,t);
        return dp[i][j]=a+b;  
    }
}