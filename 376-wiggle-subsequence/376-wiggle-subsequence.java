class Solution {
    // it may start with negitive or pos ans diff should not be zero
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1)
            return 1;
        HashMap<String,Integer>dp=new HashMap<String,Integer>();
        return Math.max(largestSub(0,-1,nums,0,dp),largestSub(0,1001,nums,1,dp));
    }
    
    private int largestSub(int curr, int prev,int nums[],int flag,HashMap<String,Integer>memo)
    {
        if(curr==nums.length)
            return 0;
        String currKey=curr+"-"+prev+"-"+flag;
        if(memo.containsKey(currKey))
            return memo.get(currKey);
        int pick=0;
        if(flag!=0 && (nums[curr]-prev<0||curr==0))
            pick=1+largestSub(curr+1,nums[curr],nums,0,memo);
        else if(flag!=1 && (nums[curr]-prev>0||curr==0))
            pick=1+largestSub(curr+1,nums[curr],nums,1,memo);
        int notPick=largestSub(curr+1,prev,nums,flag,memo);
        memo.put(currKey,Math.max(pick,notPick));
        return memo.get(currKey);            
    }
}