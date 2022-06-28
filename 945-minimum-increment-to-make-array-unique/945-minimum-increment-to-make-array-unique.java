class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length; HashMap<Integer,Boolean>hs1= new HashMap<>();
        Arrays.sort(nums); int count=0; int prev=nums[0];
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(!hs1.containsKey(num)){
                hs1.put(num,true);
                prev=num;
            }
            else{
                hs1.put(prev+1,true);
                count+=prev+1-nums[i];
                prev++;
            }
        }
        return count;
        //return solve(nums);
    }
    
}