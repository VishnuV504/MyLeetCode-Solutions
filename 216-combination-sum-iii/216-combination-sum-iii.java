class Solution {
    List<List<Integer>>ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>li = new ArrayList<>();
        solve(1,k,n,li);
        return ans;
    }
    private void solve(int curr,int k,int n,List<Integer>li)
    {
        if(k==0)
        {
            if(n==0)
                ans.add(new ArrayList<Integer>(li));
            return;
        }
        for(int i=curr;i<=9;i++)
        {
            if(i<=n)
            {
                
                li.add(i);
                solve(i+1,k-1,n-i,li);
                li.remove(li.size()-1);
            }
            else
                return;
        }
    }
}