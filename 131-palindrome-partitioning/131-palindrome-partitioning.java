class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<List<String>>();
        List<String>li = new ArrayList<>();
        HashMap<String,Boolean>hs1 = new HashMap<>();
        generateAllPalin(s,hs1);
        solve(0,s,ans,li,hs1);
        return ans;
        
    }
    private void solve(int curr,String s,List<List<String>>ans,List<String>li,HashMap<String,Boolean>hs1)
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
            if(hs1.containsKey(a))
            {
                li.add(a);
                solve(i+1,s,ans,li,hs1);
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
    private void generateAllPalin(String s,HashMap<String,Boolean>hs1)
    {
        for(int i=0;i<s.length();i++)
        {
            String k="";
            for(int j=i;j<s.length();j++)
            {
                k+=s.charAt(j);
                if(!hs1.containsKey(k))
                {
                    if(checkPalin(0,k.length()-1,k))
                        hs1.put(k,true);
                }
                
            }
        }
    }
}