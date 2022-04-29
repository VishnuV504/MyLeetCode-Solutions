class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int freq[]= new int[26];
        int freq2[] = new int[26];
        for(int i=0;i<word1.length();i++)
            freq[(int)word1.charAt(i)-'a']++;
        for(int i=0;i<word2.length();i++)
            freq2[(int)word2.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
            if(freq[i]>0 &&freq2[i]==0) return false; // word1 char should present in word2
        Arrays.sort(freq);
        Arrays.sort(freq2);
        for(int i=0;i<26;i++) // freq matters
            if(freq[i]!=freq2[i]) return false;
        return true;
    }
}