class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0; int j= nums.length-1;
        while(i<j)
        {
            if((nums[i]&1)==0)
            {
                if((nums[i]&1)==1)
                    j--;
                    i++;
            }
            else
            {
                if((nums[j]&1)==0)
                {
                    nums[i]=nums[i]^nums[j];
                    nums[j]=nums[i]^nums[j];
                    nums[i]=nums[i]^nums[j];
                    i++;
                }
                j--;     
            }
        }
        return nums;
        
    }
}