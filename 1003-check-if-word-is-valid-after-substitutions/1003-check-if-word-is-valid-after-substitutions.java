class Solution {
    public boolean isValid(String s) {
        Stack<Character>st1 = new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!='c')
                st1.push(s.charAt(i));
            else
            {
                if(st1.isEmpty()==true) return false;
                if(st1.pop()!='b') return false;
                if(st1.isEmpty()==true) return false;
                if(st1.pop()!='a') return false;
            }
        }
        return st1.isEmpty();
        
    }
}