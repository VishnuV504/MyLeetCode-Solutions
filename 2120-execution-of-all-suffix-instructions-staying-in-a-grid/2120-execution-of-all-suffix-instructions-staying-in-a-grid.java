class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] arr = new int[s.length()];
        int currRow=startPos[0];
        int currCol=startPos[1];
        HashMap<String,Integer>dp = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int ans = count(i,currRow,currCol,s,n,dp);
            arr[i]=ans;
        }
        return arr;
    }
    private int count(int currIndex,int currRow,int currCol,String s,int n,HashMap<String,Integer>dp)
    {
        if(currRow<0 ||currRow>=n||currCol<0||currCol>=n||currIndex>s.length()-1)
            return 0;
        String currKey=currIndex+"-"+currRow+"-"+currCol;
        if(dp.containsKey(currKey))
            return dp.get(currKey);
        int ans=0;
        if(s.charAt(currIndex)=='R' &&currCol+1<n)
            ans= 1+count(currIndex+1,currRow,currCol+1,s,n,dp);
        else if(s.charAt(currIndex)=='D'&& currRow+1<n)
            ans= 1+count(currIndex+1,currRow+1,currCol,s,n,dp);
        else if(s.charAt(currIndex)=='L'&&currCol-1>=0)
            ans= 1+count(currIndex+1,currRow,currCol-1,s,n,dp);
        else if(s.charAt(currIndex)=='U'&&currRow-1>=0)
            ans= 1+count(currIndex+1,currRow-1,currCol,s,n,dp);
         dp.put(currKey,ans);
        return dp.get(currKey);
    }
}