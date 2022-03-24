class Solution {
    public int pivotIndex(int[] nums) {
        int LeftSum[] = new int[nums.length];
        LeftSum[0]= nums[0];
        for(int i=1;i<nums.length;i++)
        {
            LeftSum[i]=LeftSum[i-1]+nums[i];
        }
        
        if(LeftSum[nums.length-1]-nums[0]==0)// to handle edge case if the ans is 0th index element
            return 0;
        for(int j=1;j<nums.length;j++)
        {
            if(LeftSum[j-1]==LeftSum[nums.length-1]-LeftSum[j-1]-nums[j])
                return j;
        }
        return -1;
        
    }
    
}