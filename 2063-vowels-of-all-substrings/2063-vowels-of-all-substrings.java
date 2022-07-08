class Solution {
    public long countVowels(String word) {
        int n=word.length(); long ans=0;
        long dp[]=new long[n];
        if(isVowel(word.charAt(0))){
            dp[0]=1; ans++;
        }
        for(int i=1;i<n;i++){
            if(isVowel(word.charAt(i)))
                dp[i]=dp[i-1]+i+1;
            else
                dp[i]=dp[i-1];
            ans+=dp[i];
        }
        return ans;
    }
    private boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        return false;
    }
}