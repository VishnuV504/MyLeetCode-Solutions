class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        StringBuilder str = new StringBuilder();
        String mapping[]= {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(0,digits,mapping,str,ans);
        return ans;
        
    }
    private void solve(int curr,String digits,String[] mapping,StringBuilder str,List<String>ans)
    {
        if(curr==digits.length())
        {
            String a= new String(str);
            ans.add(a);
            return;
        }
        for(int i=0;i<mapping[(digits.charAt(curr)-50)].length();i++)
        {
            str.append(mapping[(digits.charAt(curr)-50)].charAt(i));
            solve(curr+1,digits,mapping,str,ans);
            str.deleteCharAt(str.length()-1);
        }
        
    }
}