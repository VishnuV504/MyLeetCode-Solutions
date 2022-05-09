class Solution {
    public boolean isValid(String s) {
        Deque<Character>dq= new ArrayDeque<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!='c')
                dq.add(s.charAt(i));
            else
            {
                if(dq.isEmpty()==true) return false;
                if(dq.removeLast()!='b') return false;
                if(dq.isEmpty()==true) return false;
                if(dq.removeLast()!='a') return false;
            }
        }
        return dq.isEmpty();
        
    }
}