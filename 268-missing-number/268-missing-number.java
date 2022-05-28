class Solution {
    public int missingNumber(int[] nums) {
        return missing(nums);
    }
    private int missing(int nums[])
    {
        int currXor=0; int n=nums.length;
        for(int i=0;i<n;i++)
            currXor^=nums[i];
        int totalXor=0;
        int rem=n%4;
        if(rem==0)totalXor=n;
        else if(rem==1) totalXor=1;
        else if(rem==2) totalXor=n+1;
        else totalXor=0;
        return currXor^totalXor;
    }
}