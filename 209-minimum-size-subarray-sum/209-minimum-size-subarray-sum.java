class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLength=Integer.MAX_VALUE;
        int prefixSum[] = new int[n];
        prefixSum[0]=nums[0];
        if(nums[0]>=target) return 1;
        for(int i=1;i<n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+nums[i];
            if(prefixSum[i]>=target)
            {
                int index=findUpperBound(prefixSum,prefixSum[i]-target,i-1);
                //System.out.println(index+" "+i);
               if(index!=-1)
                   minLength=Math.min(minLength,i-index);
                else
                    minLength=Math.min(minLength,i+1);
            }
        }
        if(minLength==Integer.MAX_VALUE)
            return 0;
        return minLength;
    }
    private int findUpperBound(int prefixSum[],int target,int j)
    {
        int index=-1;
        int i=0;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(prefixSum[mid]<=target)
            {
                index=mid;
                i=mid+1;
            }
            else
                j=mid-1;
        }
        return index;
        
    }
}