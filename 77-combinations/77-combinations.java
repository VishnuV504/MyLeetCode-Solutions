class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        List<Integer>li = new ArrayList<>();
        solve(1,n,k,li,ans);
        return ans;
        
    }
    private void solve(int curr,int n, int k,List<Integer>li,List<List<Integer>>ans)
    {
        if(li.size()==k)
        {
            ans.add(new ArrayList<Integer>(li));
            return;
        }
        for(int i=curr;i<=n;i++)
        {
            li.add(i);
            solve(i+1,n,k,li,ans);
            li.remove(li.size()-1);
        }
    }
}