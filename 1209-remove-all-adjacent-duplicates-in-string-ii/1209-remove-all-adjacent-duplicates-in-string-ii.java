class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>>st1 = new Stack<Pair<Character,Integer>>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            if(st1.size()==0||st1.peek().getKey()!=s.charAt(i))
            {
                Pair <Character,Integer> ans = new Pair <Character,Integer> (s.charAt(i), 1);
                st1.push(ans);
            }
            else if(st1.peek().getKey()==s.charAt(i))
            {
                int count=st1.peek().getValue();
                if(count==k-1)
                {
                    int a=k-1;
                    while(a!=0)
                    {
                        st1.pop();
                        a--;
                    }
                }
                else
                {
                    Pair <Character,Integer> ans = new Pair <Character,Integer> (s.charAt(i), count+1);
                st1.push(ans);
                }
            }
        }
        StringBuilder result=new StringBuilder();
        while(st1.size()!=0)
        {
            result.append(st1.pop().getKey());
        }
        result.reverse();
        return result.toString();
        
        
    }
}