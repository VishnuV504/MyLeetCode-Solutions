class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j=0; int ans=1; int count=0;
        for(int i=0;i<nums.length;i++)
        {
            ans*=nums[i];
            if(ans>=k)
            {
                while(j<nums.length&&ans>=k)
                {
                    ans/=nums[j];
                    j++;
                }
            }
            if(ans<k)
            {
                count+=i-j+1;
            }

        }
        return count;
        
    }
}
 