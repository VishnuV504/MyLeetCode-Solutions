class Solution {
    public int[] searchRange(int[] nums, int target) {
        int Result[] = new int[2];
        int i=0; int j=nums.length-1;
        int firstOccurence=-1,LastOccurance=-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target)
            {
                firstOccurence=mid;
                j=mid-1;
            }
            else if(nums[mid]>target)
                j=mid-1;
            else
                i=mid+1;
        }
        
        i=0;j=nums.length-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target)
            {
                LastOccurance=mid;
                i=mid+1;
            }
            else if(nums[mid]>target)
                j=mid-1;
            else
                i=mid+1;
        }
        Result[0]=firstOccurence;
        Result[1]=LastOccurance;
        return Result;
        
    }
}