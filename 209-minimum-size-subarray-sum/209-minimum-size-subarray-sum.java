class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLength=Integer.MAX_VALUE;
        int j=0; int prev=0; int flag=0;
        for(int i=0;i<n;i++)
        {
            while(prev+nums[i]>=target)
            {
                prev-=nums[j];
                j++;
                flag=1;
            }
            prev+=nums[i];
            if(flag==1)
            {
                flag=0;
            minLength=Math.min(minLength,i-j+2);
            }
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        return minLength;
        
        
    }
}