class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int y=0;
        int x=solveAtMostK(nums,k);
            k--; 
        if(k!=0)
        y= solveAtMostK(nums,k);
        return x-y;
    }
    private int solveAtMostK(int nums[],int k)
    {
        int count=0; int distinct=0;int n=nums.length;
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int j=0;
        for(int i=0;i<n;i++){
            while(!hs1.containsKey(nums[i])&&distinct==k)//atmost k
            {
                if(hs1.get(nums[j])==1)
                {
                    hs1.remove(nums[j]);
                    distinct--;
                }
                else
                    hs1.put(nums[j],hs1.get(nums[j])-1);
                j++;
            }
            if(hs1.containsKey(nums[i]))
                hs1.put(nums[i],hs1.get(nums[i])+1);
            else
            {
                hs1.put(nums[i],1);
                distinct++;
            }
                count+=i-j+1;
        }
        return count;
    }
}