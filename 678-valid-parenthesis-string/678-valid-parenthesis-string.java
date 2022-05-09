class Solution {
    Boolean dp[][] = new Boolean[101][102];
    public boolean checkValidString(String s) {
        return solve(0,s,s.length(),0);  
    }
    private boolean solve(int curr,String s,int n,int sum)
    {
        //System.out.println(sum);
        if(curr>n||sum<0) return false;
        if(curr==n) 
            return sum==0;
        if(dp[curr][sum]!=null) return dp[curr][sum];
        boolean a=false; boolean b=false;
        if(s.charAt(curr)!='*')
        {
            sum=(s.charAt(curr)=='(')?++sum:--sum;
            //System.out.println(sum+" "+curr+"before");
           a=solve(curr+1,s,n,sum);
            sum=(s.charAt(curr)=='(')?--sum:++sum;
            //System.out.println(sum+" "+curr+"after");
        }
        else
           b=solve(curr+1,s,n,sum+1)||solve(curr+1,s,n,sum-1)||solve(curr+1,s,n,sum); 
        dp[curr][sum]=a||b;
        return a||b;
    }
}