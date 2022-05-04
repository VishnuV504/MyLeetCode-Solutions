class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>hs1= new HashMap<>();
        int j=0; int count=0; int n=s.length();
        int distinct=0;
        for(int i=0;i<n;i++)
        {
            while(!hs1.containsKey(s.charAt(i))&&distinct==2)
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
            if(hs1.containsKey(s.charAt(i)))
                hs1.put(s.charAt(i),hs1.get(s.charAt(i))+1);
            else
            {
                hs1.put(s.charAt(i),1);
                distinct++;
            }
                count+=i-j+1;
            
        }
        long a=n; long b=n+1;
        return (int)((a*b)/2-count);
        
    }
}