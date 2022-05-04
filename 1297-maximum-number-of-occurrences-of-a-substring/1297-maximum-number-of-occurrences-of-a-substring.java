class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character,Integer>hs1 = new HashMap<>();
        HashMap<String,Integer>hs2 = new HashMap<>();
        int distinct=0; int j=0; int n=s.length();
        for(int i=0;i<n;i++)
        {
            char a= s.charAt(i);
            while(!hs1.containsKey(a)&&distinct==maxLetters||i-j==minSize)
            {
                if(hs1.get(s.charAt(j))==1)
                {
                    hs1.remove(s.charAt(j));
                    distinct--;
                }
                else
                    hs1.put(s.charAt(j),hs1.get(s.charAt(j))-1);
                j++;
            }
            if(hs1.containsKey(a))
                    hs1.put(a,hs1.get(a)+1);
                else
                {
                    hs1.put(a,1);
                    distinct++;
                }

            System.out.println(s.substring(j,i+1));
            //String curr=s.substring(j,i+1);
            if((i-j)+1>=minSize && (i-j)+1<=maxSize)
            {
                String curr=s.substring(j,i+1);
                
                if(hs2.containsKey(curr))
                    hs2.put(curr,hs2.get(curr)+1);
                else
                    hs2.put(curr,1);
            }
        }
        int max=0;
        for(String key :hs2.keySet())
            max=Math.max(max,hs2.get(key));
        return max;
            
        
    }
}