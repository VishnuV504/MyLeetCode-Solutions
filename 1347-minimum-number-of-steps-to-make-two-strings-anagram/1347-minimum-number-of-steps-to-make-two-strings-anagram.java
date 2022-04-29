class Solution {
    public int minSteps(String s, String t) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            int a= (int)(s.charAt(i)-'a');
            freq[a]++;
        }
        int count=0;
        for(int j=0;j<t.length();j++)
        {
            int b=(int)(t.charAt(j)-'a');
            if(freq[b]!=0)
                freq[b]--;
            else
                count++;
        }
        return count;
        
    }
}