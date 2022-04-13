class Solution {
    public int BinarySearch(int arr[],int low,int high)
    {
        int mid=low+(high-low)/2;
        if(low>high)
            return -1;
        else
            if(mid!=arr.length-1 && mid!=0 && arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1] )
                return arr[mid];
            else if(arr[mid]>=arr[0]) // we have to go rightside because if arr[mid]>arr[0] it mean upto that part array is not rotated if it rotated arr[mid]>arr[0] is not possible take a example and check that
                return BinarySearch(arr,mid+1,high);
                return BinarySearch(arr,low,mid-1);
        
            
            
    }
    public int findMin(int[] nums) {
        int num= BinarySearch(nums,0,nums.length-1);
        if(num==-1) // if it returns -1 means min element is present in last index or firstindex
        return Math.min(nums[0],nums[nums.length-1]);
        return num;
        
    }
}