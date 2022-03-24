class Solution {
    public int majorityElement(int[] nums) {
        int MajorityElement=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==MajorityElement)
                count++;
            else if(nums[i]!=MajorityElement && count!=1)
                count--;
            else
            {
                count=1;
                MajorityElement=nums[i];
            }
        }
        return MajorityElement;
    }
}