class Solution {
    int dp[][]= new int[1002][1002];
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        for(int i=0;i<1000;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,words,-1);  
    }
    private int solve(int curr,String words[],int prev)
    {
        if(curr==words.length)
            return 0;
        String currKey=curr+"-"+prev;
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        int cons=0;
        if(prev==-1||isValid(words[prev],words[curr]))
            cons=1+solve(curr+1,words,curr);
        int notCons=solve(curr+1,words,prev);
       return dp[curr][prev+1]=Math.max(cons,notCons);
    }
    private boolean isValid(String a, String b)
    {
        if(a.length()==0) return true;
        if(a.length()+1!=b.length())return false;
        int i=0;int j=0; int k=1; int m=a.length(); int n=b.length();
        while(i<m && j<n)
        {
            if(a.charAt(i)==b.charAt(j))
            {
                i++;j++;
            }
            else if(k==1)
            {
                j++;k=0;
            }
            else
                return false;
        }
         if(i+1==j||k==1)
             return true;
        return false;
    }
}