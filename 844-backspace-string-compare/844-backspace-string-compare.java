class Solution {
    public boolean backspaceCompare(String s, String t) {
        String check1="";
        String check2=""; int count1=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='#')
                count1++;
            else if(count1==0)
                check1+=s.charAt(i);
            else
                count1--;
        }
        int count2=0;
        for(int i=t.length()-1;i>=0;i--)
        {
            if(t.charAt(i)=='#')
                count2++;
            else if(count2==0)
                check2+=t.charAt(i);
            else
                count2--;
        }
        //System.out.println(check1+" "+check2);
        return check1.equals(check2);
        
    }
}