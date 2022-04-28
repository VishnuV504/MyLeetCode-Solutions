class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>>ans = new HashSet<List<Integer>>();
        List<Integer>li = new ArrayList<>();
        solve(0,nums,ans,li,-101);
        List<List<Integer>>res = new ArrayList<List<Integer>>(ans);
        return res;
        
    }
    private void solve(int curr,int nums[],Set<List<Integer>>ans,List<Integer>li,int prev)
    {
        if(curr==nums.length)
        {
            if(li.size()>1)
            ans.add(new ArrayList<Integer>(li));
            return;
        }
        if(nums[curr]>=prev)
        {
            li.add(nums[curr]);
            solve(curr+1,nums,ans,li,nums[curr]);
            li.remove(li.size()-1);
        }
        solve(curr+1,nums,ans,li,prev);
    }
}