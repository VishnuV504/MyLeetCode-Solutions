class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // find from left and right
        int left=-1; int right=-1; int n= nums.length;
        for(int i=0; i+1<n; i++)
        {
            if(nums[i]>nums[i+1])
            {
                left=i; break;
            }
        }
        for(int i=n-1;i>0;i--)
        {
            if(nums[i-1] > nums[i])
            {
                right=i;
                break;
            }
        }
        if(left==-1&&right==-1) return 0;
        if(left==right) return Math.min(left+1,n-left);
        int count=0; int smallest=Integer.MAX_VALUE; int largest=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++)  //find smallest element in that subarray and largest too
        {
            smallest=Math.min(smallest,nums[i]);
            largest=Math.max(largest,nums[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>smallest)
            {
                left=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]<largest)
            {
                right=i;
                break;
            }
        }
        return right-left+1;
        // think about the case where left> right ? ex:[2,1]
    }
}