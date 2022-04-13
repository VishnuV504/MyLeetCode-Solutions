class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            count+=totalPalin(i,i,s);
        return count;
    }
    private int totalPalin(int index,int curr,String s)
    {
        if(curr>=s.length())
            return 0;
        if(checkPalin(index,curr,s))
            return 1+totalPalin(index,curr+1,s);
        return totalPalin(index,curr+1,s);
    }
    private boolean checkPalin(int i,int j,String s)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}