class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String>ans = new ArrayList<String>();
        StringBuilder str = new StringBuilder(s);
        int length=s.length();
        solve(0,s,str,ans,length,false);
        return ans;
        
    }
    private void solve(int curr,String s,StringBuilder str,List<String>ans,int length,boolean flag)
    {
        if(curr>=length)
        {
            ans.add(str.toString());
            return;
        }
        if(Character.isDigit(str.charAt(curr))) 
        {
            solve(curr+1,s,str,ans,length,false);
            return;
        }
        if(flag==false)
        {
            str.setCharAt(curr,Character.toUpperCase(str.charAt(curr)));
            solve(curr+1,s,str,ans,length,false);
            str.setCharAt(curr,Character.toLowerCase(str.charAt(curr)));
        }
        solve(curr+1,s,str,ans,length,false);
        
    }
}