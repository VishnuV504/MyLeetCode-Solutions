class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDis=0;
        for(int i=0;i<nums1.length;i++)
        {
            int dis=BinarySearch(i,nums2.length-1,nums2,nums1[i])-i;
            if(dis>maxDis)
                maxDis=dis;
        }
        return maxDis;   
    }
    private int BinarySearch(int low,int high, int arr[],int target)
    {
        int upperBound=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>=target)
            {
                upperBound=mid;
                low=mid+1;
            }
            else
                high=mid-1;   
        }
        return upperBound;
    }
}