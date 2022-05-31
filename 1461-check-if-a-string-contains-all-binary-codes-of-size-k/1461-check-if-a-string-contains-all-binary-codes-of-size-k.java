class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        if(k>n) return false;
        HashMap<String,Boolean>hs1 = new HashMap<>();
        StringBuilder ans=new StringBuilder(); int length=0;
        int overAllLength=0;
        for(int i=0;i<n;i++)
        {
            ans.append(s.charAt(i));
            length++;
            if(length==k)
            {
                String str=new String(ans);
                if(!hs1.containsKey(str))
                {
                    hs1.put(str,true);
                    overAllLength++; 
                }
                ans.deleteCharAt(0);
                length--;
            }
        }
        return overAllLength==(int)Math.pow(2,k);
    }
}