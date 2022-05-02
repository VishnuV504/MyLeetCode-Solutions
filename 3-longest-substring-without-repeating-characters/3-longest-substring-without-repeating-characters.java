class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0; int j=0; int n=s.length();
        HashMap<Character,Integer>hs1 = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char curr= s.charAt(i);
            while(hs1.containsKey(curr))
            {
                hs1.remove(s.charAt(j));
                j++;
            }
            hs1.put(curr,1);
            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;
        
    }
}