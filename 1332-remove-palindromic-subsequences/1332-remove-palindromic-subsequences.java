class Solution {
    public int removePalindromeSub(String s) {
        int i=0;int j=s.length()-1;
        boolean flag=false;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                flag=true;
                break;
            }
            i++;
            j--;
        }
        if(flag)return 2;
        return 1;
        
    }
}