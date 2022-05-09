class Solution {
    int dp[]=new int[100005]; long mod=1000000007;
    public int countTexts(String pressedKeys) {
        Arrays.fill(dp,-1);
        return solve(0,pressedKeys);   
    }
    private int solve(int curr,String pressedKeys)
    {
        if(curr>=pressedKeys.length()) 
            return 1; 
        if(dp[curr]!=-1) return dp[curr];
        int moveTwo=0;int moveThree=0;int moveFour=0;
       int moveOne=(int)(solve(curr+1,pressedKeys)%mod);
        if(curr+1<pressedKeys.length()&&pressedKeys.charAt(curr)==pressedKeys.charAt(curr+1))
       moveTwo=(int)(solve(curr+2,pressedKeys)%mod); if(curr+2<pressedKeys.length()&&pressedKeys.charAt(curr)==pressedKeys.charAt(curr+1)&&pressedKeys.charAt(curr+2)==pressedKeys.charAt(curr+1))
       moveThree=(int)(solve(curr+3,pressedKeys)%mod);
        if(pressedKeys.charAt(curr)=='7' &&curr+3<pressedKeys.length()&&pressedKeys.charAt(curr)==pressedKeys.charAt(curr+1)&&pressedKeys.charAt(curr+2)==pressedKeys.charAt(curr+3)&&pressedKeys.charAt(curr+2)==pressedKeys.charAt(curr+1))
       moveFour=(int)(solve(curr+4,pressedKeys)%mod);
        if(pressedKeys.charAt(curr)=='9' &&curr+3<pressedKeys.length()&&pressedKeys.charAt(curr)==pressedKeys.charAt(curr+1)&&pressedKeys.charAt(curr+2)==pressedKeys.charAt(curr+3)&&pressedKeys.charAt(curr+2)==pressedKeys.charAt(curr+1))
        moveFour=(int)(solve(curr+4,pressedKeys)%mod);
        int a=(int)((moveOne+moveTwo)%mod);
        int b=(int)((moveThree+moveFour)%mod);
        int c=(int)((a+b)%mod);
        return dp[curr]=c;
        
    }
}