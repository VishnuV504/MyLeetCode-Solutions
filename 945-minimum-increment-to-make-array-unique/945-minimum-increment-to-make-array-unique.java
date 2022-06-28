class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length; 
        Arrays.sort(nums); int count=0; int prev=nums[0];
        for(int i=1;i<n;i++){
            int num=nums[i];
            if(nums[i]>prev)
                prev=num;
            else{ 
                count+=prev+1-nums[i];
                prev++;
            }
        }
        return count;
    }
    
}