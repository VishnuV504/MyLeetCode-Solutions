class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>li = new ArrayList<>();
        if(s.length()<=10) return li;
        HashMap<String,Integer>hs1 = new HashMap<>();
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            
            if(ans.length()<10)
                ans+=s.charAt(i);
            if(ans.length()==10)
            {
                //System.out.println(ans);
                if(hs1.containsKey(ans))
                    hs1.put(ans,hs1.get(ans)+1);
                else
                    hs1.put(ans,1);
                StringBuilder str= new StringBuilder(ans);
                str.deleteCharAt(str.length()-10);
                ans= str.toString();
            }
        }
        
        for(String key : hs1.keySet())
        {
            if(hs1.get(key)>1)
            {
                li.add(key);
            }
        }
        return li;
        
    }
}