class Solution {
    //List<List<Integer>>ans = new ArrayList<List<Integer>>();
    //List<Integer>li= new ArrayList<>();
    int dp[][] =new int[1002][1002];
    public int numDistinct(String s, String t) {
        // for(int i=0;i<ans.size();i++)
        // {
        //     for(int j=0;j<ans.get(i).size();j++)
        //         System.out.print(ans.get(i).get(j)+" ");
        //     System.out.println();
        // }
        for(int i=0;i<1002;i++)
            Arrays.fill(dp[i],-1);
        return  solve(0,0,s,t);
    }
    private int solve(int i,int j, String s, String t)
    {
        if(i==s.length() && j==t.length())
        {
            //ans.add(new ArrayList<Integer>(li));
            return 1;
        }
        if(i>=s.length())
            return 0;
        if(j>=t.length())
        {
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int a=0;
        if(s.charAt(i)==t.charAt(j))
        {
            //li.add(i);
           a=solve(i+1,j+1,s,t);
            //li.remove(li.size()-1);
        }
        int b=solve(i+1,j,s,t);
        return dp[i][j]=a+b;
        
    }
}