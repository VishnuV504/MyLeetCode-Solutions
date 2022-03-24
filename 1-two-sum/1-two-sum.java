class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>Check= new HashMap<>();
        int[] arr =new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(Check.containsKey(target-nums[i]))
            {
                arr[0]=i;
                arr[1]=Check.get(target-nums[i]);
                break;
            }
            Check.put(nums[i],i);
        }
        return arr;
        
        
    }
}