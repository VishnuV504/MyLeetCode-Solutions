class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int preSum=0;
        hs1.put(0,1); int count=0; int n=nums.length;
        for(int i=0;i<n;i++)
        {
            preSum+=nums[i];
            if(hs1.containsKey(preSum-k))
                count+=hs1.get(preSum-k);
            if(!hs1.containsKey(preSum))
                hs1.put(preSum,1);
            else
                hs1.put(preSum,hs1.get(preSum)+1);
        }
        return count;
        
    }
}