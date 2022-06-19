class Solution {
    public int longestSubsequence(String s, int k) {
        int count=0;
        int x=0;
        int num=k;
        while(num!=0)
        {
            x++;
            num/=2;
            
        }
        x=Math.min(x,s.length());
        int sum=0;
        for(int i=s.length()-x;i<s.length();i++)
        {
            sum*=2;
            if(s.charAt(i)=='1')
            sum+=1;
            if(sum>k) break;
            count++;
        }
        for(int i=0;i<s.length()-x;i++)
        {
            if(s.charAt(i)=='0')
                count++;
        }
        return count;
    }
}