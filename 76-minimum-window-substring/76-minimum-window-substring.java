class Solution {
    public String minWindow(String s, String t) {
        int freq[]=new int[128]; int index=-1;
        for(int i=0;i<t.length();i++)
            freq[(int)t.charAt(i)]++;
        int freq2[]=new int[128]; int j=0; int minLength=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            freq2[s.charAt(i)]++;
            boolean flag=false;
            while(isEqual(freq,freq2)){
                freq2[(int)s.charAt(j)]--;
                j++;
                flag=true;
            }
            if(flag){
               // minLength=Math.min(minLength,i-j+1);
                if(i-j+1<minLength){
                    index=j;
                    minLength=i-j+1;
                }
            }
        }
        String ans="";
        if(index!=-1)
            ans=s.substring(index-1,index+minLength);
        return ans;
        
    }
    public boolean isEqual(int freq[],int freq2[]){
        for(int i=0;i<128;i++){
            if(freq2[i]>=freq[i]) continue;
            return false;
        }
        return true;
    }
}