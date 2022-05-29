class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int freq[][]= new int[n][26];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<words[i].length();j++)
            freq[i][(int)(words[i].charAt(j)-'a')]++;
        }
        int maxLength=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                boolean flag=false;
                for(int k=0;k<26;k++)
                {
                    if(freq[i][k]>=1 && freq[j][k]>=1)
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag==false)
                maxLength=Math.max(maxLength,words[i].length()*words[j].length());
            }
        }
        return maxLength;
        
    }
}