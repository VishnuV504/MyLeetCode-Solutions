class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] Result = new int[2];
        int low=0,high=numbers.length-1;
        while(low<high)
        {
            int check=numbers[low]+numbers[high];
            if(check==target)
            {
                Result[0]=low+1;
                Result[1]=high+1;
                return Result;
            }
            else if(check>target)
                high--;
            else
                low++;
        }
        return Result;  
    }
}