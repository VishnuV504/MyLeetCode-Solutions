class Solution {
    int count=0;
    String ans=""; 
    char arr[] = {'a','b','c'};
    public String getHappyString(int n, int k) {
        StringBuilder str = new StringBuilder();
        solve(0,n,k,str);
        return ans;
    }
    private void solve(int curr,int n,int k,StringBuilder str)
    {
        if(curr==n)
        {
            count++;
            if(count==k)
                ans=str.toString();
            return;    
        }
        if(count==k) return;
        for(int i=0;i<3;i++)
        {
            if(str.length()==0||arr[i]!=str.charAt(str.length()-1))
            {
                str.append(arr[i]);
                //System.out.println(str);
                solve(curr+1,n,k,str);
                str.deleteCharAt(str.length()-1);
            }
            
        }
    }
}