class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int k=0;k<=nums.length;k++)
        {
            int i=0; int j=nums.length-1;
            while(i<=j)
            {
                int mid=i+(j-i)/2;
                if(nums[mid]>=k)
                    j=mid-1;
                else
                    i=mid+1;
            }
            if(nums.length-i==k)
                return k;
            
        }
        return -1;
        
    }
}