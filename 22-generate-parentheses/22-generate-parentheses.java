class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        StringBuilder str= new StringBuilder();
        solve(n*2,ans,str,0,0,n);
        return ans;
        
    }
    private void solve(int n,List<String>ans,StringBuilder str,int left,int right,int k)
    {
        if(n==0) 
        {
            ans.add(str.toString());
            return;
        }
        if(left<k)
        {
            solve(n-1,ans,str.append('('),left+1,right,k);
            str.deleteCharAt(str.length()-1);
        }
        if(left>right && right<k)
        {
            solve(n-1,ans,str.append(')'),left,right+1,k);
            str.deleteCharAt(str.length()-1);
        }
        
        
    }
}