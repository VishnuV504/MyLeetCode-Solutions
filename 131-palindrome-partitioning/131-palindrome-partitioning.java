class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<List<String>>();
        List<String>li = new ArrayList<>();
        solve(0,s,ans,li);
        return ans;
        
    }
    private void solve(int curr,String s,List<List<String>>ans,List<String>li)
    {
        if(curr==s.length())
        {
            ans.add(new ArrayList<String>(li));
            return ;
        }
        String a="";
        for(int i=curr;i<s.length();i++)
        {
            a+=s.charAt(i);
            if(checkPalin(0,a.length()-1,a))
            {
                li.add(a);
                solve(i+1,s,ans,li);
                li.remove(li.size()-1);
            }
        }
    }
    
    private boolean checkPalin(int low,int high,String str)
    {
        while(low<high)
        {
            if(str.charAt(low)!=str.charAt(high)) 
                return false;
            low++;
            high--;
        }
        return true;
    }
}