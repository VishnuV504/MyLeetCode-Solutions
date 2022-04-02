class Solution {
    public boolean check(int i, int j, String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0; int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                boolean a=false;
                boolean b= false;
                if(s.charAt(i)==s.charAt(j-1))
                {
                   a= check(i+1,j-2,s);
                }
                if(s.charAt(i+1)==s.charAt(j))
                {
                   b= check(i+2,j-1,s);
                }
                return a||b;
                
            }
            else
            {
                i++;j--;
            }  
        }
        return true;
        
    }
}