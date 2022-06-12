class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length; HashMap<Integer,Integer>hs1 = new HashMap<>();
        int ans=Integer.MIN_VALUE; int j=0; int score=0;
        for(int i=0;i<n;i++)
        {
            while(hs1.containsKey(nums[i]))
            {
                hs1.remove(nums[j]);
                score-=nums[j];
                j++;
            }
            score+=nums[i];
            hs1.put(nums[i],1);
            ans=Math.max(ans,score);
        }
        return ans;
        
    }
}