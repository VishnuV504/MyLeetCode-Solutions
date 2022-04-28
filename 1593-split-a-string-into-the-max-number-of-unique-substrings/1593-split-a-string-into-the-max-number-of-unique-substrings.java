class Solution {
    public int maxUniqueSplit(String s) {
        int maxLength[] = new int[1];
        HashMap<String,Integer>hs1 = new LinkedHashMap<>();
        solve(0,s,hs1,maxLength);
        return maxLength[0];
    }
    private void solve(int curr,String s,HashMap<String,Integer>hs1,int maxLength[])
    {
        if(curr==s.length())
        {
            if(hs1.size()>maxLength[0])
                maxLength[0]=hs1.size();
            return;
        }
        String ans="";
        for(int i=curr;i<s.length();i++)
        {
            ans+=s.charAt(i);
            if(!hs1.containsKey(ans))
            {
                hs1.put(ans,1);
                solve(i+1,s,hs1,maxLength);
                hs1.remove(ans);
            }
        }
    }
}