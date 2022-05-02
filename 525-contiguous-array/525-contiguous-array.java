class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int prev=0; int n= nums.length; int maxLength=0;
        hs1.put(0,-1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
                prev+=-1;
            else 
                prev+=1;
            if(hs1.containsKey(prev))
               maxLength= Math.max(maxLength,i-hs1.get(prev));
            else
                hs1.put(prev,i);
        }
        return maxLength;
        
        
    }
}