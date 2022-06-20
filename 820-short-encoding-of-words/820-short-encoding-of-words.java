class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n=words.length; int len=0;
        sort(words,n);
        HashMap<String,Boolean>hs1 = new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {
            if(hs1.containsKey(words[i])) continue;
            StringBuilder check= new StringBuilder(words[i]);
            while(check.length()!=0)
            {
                hs1.put(check.toString(),true);
                check.deleteCharAt(0);
            }
            len+=words[i].length()+1;
        }
        return len;
        
    }
    private static void sort(String []s, int n)
    {
        for (int i=1;i<n;i++)
        {
            String temp=s[i];
            int j=i-1;
            while(j>=0&&temp.length()<s[j].length())
            {
                s[j+1] = s[j];
                j--;
            }
            s[j+1]=temp;
        }
    }   
}