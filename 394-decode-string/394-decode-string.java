class Solution {
    public String decodeString(String s) {
        Stack<Character>st1 = new Stack<>();
        String ans2="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=']')
                st1.push(s.charAt(i));
            else
            {
                String ans="";
                while(st1.peek()!='[')
                {
                    ans+=st1.pop(); // retrive the string which is in brackets
                }
                st1.pop();// pop opening brace
                String repeat1= "";
                while(st1.size()!=0 && Character.isDigit(st1.peek()))
                {
                    repeat1+=st1.pop(); // is used to retrive how many times i have to repeat
                }
                StringBuilder b = new StringBuilder(repeat1);
                b.reverse();  // we have to reverse the repeat because ex:100 when we retrive 100 it's like 001 which is 1  so we have to reverse it will become 100
                int repeat=Integer.parseInt(b.toString());
                while(repeat!=0)
                {
                    for(int j=ans.length()-1;j>=0;j--)
                    {
                        st1.push(ans.charAt(j)); // repeat the string which is in brace and push in the stack why we pushing? refer to example2
                    }
                    repeat--;
                }
            }
        }
        // get all the characters from the stack ans reverse
        String dup = "";
        while(st1.size()!=0)
        {
            dup+=st1.pop();
        }
        StringBuilder a = new StringBuilder(dup);
        a.reverse();
        ans2+=a;      
        return ans2;
        
    }
}