class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        List<Integer>li = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,li,ans);
        return ans;
    }
    private void solve(int curr,int nums[],List<Integer>li,List<List<Integer>>ans)
    {
        if(curr==nums.length)
            ans.add(new ArrayList<>(li));
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]!=-100)
            {
                int temp=nums[i];
                nums[i]=-100;
                li.add(temp);
                solve(curr+1,nums,li,ans);
                li.remove(li.size()-1);
                nums[i]=temp;
            }
        }
    }
}