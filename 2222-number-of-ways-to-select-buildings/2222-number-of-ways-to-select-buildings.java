class Solution {
    public long numberOfWays(String s) {
        char prev='2';
        long dp[][][]= new long[3][3][100001];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                for(int k=0;k<=100000;k++)
                    dp[i][j][k]=-1;
        return ways(0,s,prev,0,dp);
        
    }
    private long ways(int curr,String s, char prev,int count,long dp[][][])
    {
        if(count==3)
            return 1;
        if(curr>=s.length())
            return 0;
        if(dp[prev-'0'][count][curr]!=-1)
            return dp[prev-'0'][count][curr];
        long pick=0;
        if(s.charAt(curr)!=prev)
            pick=ways(curr+1,s,s.charAt(curr),count+1,dp);
        long notPick=ways(curr+1,s,prev,count,dp);
        dp[prev-'0'][count][curr]=pick+notPick;
        return dp[prev-'0'][count][curr];
            
        
    }
}