class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=k)
            {
                if(hs1.containsKey(nums[i]))
                    hs1.put(nums[i],hs1.get(nums[i])+1);
                else
                    hs1.put(nums[i],1);
            }
        }
        int count=0; int count2=0;
        for(Integer Key: hs1.keySet())
        {
            if(Key==k/2 && (k&1)==0)
            {
                count2+=(hs1.get(k/2))/2;
            }
            else if(hs1.containsKey(k-Key))
            {
                count+=Math.min(hs1.get(Key),hs1.get(k-Key));
            }
                
        }
        return count/2+count2;
    }
}