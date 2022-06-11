class Solution {
    public int minOperations(int[] nums, int x) {
        int minLength=Integer.MAX_VALUE;
        int n=nums.length;
        int prefixSum[]= new int[n]; int suffixSum[]= new int[n];
        prefixSum[0]=nums[0]; suffixSum[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
            prefixSum[i]=prefixSum[i-1]+nums[i];
        for(int i=n-2;i>=0;i--)
            suffixSum[i]=nums[i]+suffixSum[i+1];
        for(int i=0;i<n;i++)
            if(prefixSum[i]==x)
                minLength=Math.min(minLength,i+1);
        for(int i=n-1;i>=0;i--)
            if(suffixSum[i]==x)
                minLength=Math.min(minLength,n-i);
        for(int i=n-1;i>=0;i--)
        {
            if(suffixSum[i]<x)
            {
                int bound=lowerBound(0,i-1,prefixSum,x-suffixSum[i]);
                if(bound!=-1)
                    minLength=Math.min(minLength,(n-i)+bound+1);
            }
            else 
                break;
        }   
        if(minLength==Integer.MAX_VALUE)return -1;
        return minLength;
    }
    private int lowerBound(int i, int j,int arr[],int target)
    {
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                j=mid-1;
            else
                i=mid+1;
        }
        return -1;
    }
}