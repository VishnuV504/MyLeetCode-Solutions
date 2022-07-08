class Solution {
    public long countVowels(String word) {
        int n=word.length(); long ans=0;
        long prev=0;
        if(isVowel(word.charAt(0))){
            prev=1; ans++;
        }
        for(int i=1;i<n;i++){
            if(isVowel(word.charAt(i)))
                prev+=i+1;
            ans+=prev;
        }
        return ans;
    }
    private boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        return false;
    }
}