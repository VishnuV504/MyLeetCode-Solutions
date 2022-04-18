class Solution {
    List<List<Integer>>res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>ans = new ArrayList<>();
        solve(0,candidates,target,ans);
        return res;
    }
     
    private void solve(int curr,int arr[],int k,List<Integer>ans)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(ans));
            return ;
        }
        if(curr>=arr.length)
            return;
        if(arr[curr]<=k)
        {
            ans.add(arr[curr]);
            solve(curr,arr,k-arr[curr],ans);
            ans.remove(ans.size()-1);
        }
        solve(curr+1,arr,k,ans);

    }
}