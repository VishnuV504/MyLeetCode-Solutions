class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int[] prefixSum= new int[n];
        prefixSum[0]=0;
        for(int i=0;i<n-1;i++)
            prefixSum[i+1]=prefixSum[i]+nums[i];
        int total=prefixSum[n-1]+nums[n-1];
        int ans[] = new int[n];
        for(int i=0;i<n;i++)
            ans[i]=(total-prefixSum[i])-(nums[i]*(n-i))+((nums[i]*i)-prefixSum[i]);
        return ans;
    }
}