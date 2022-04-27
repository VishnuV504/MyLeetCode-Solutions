class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR[]=new int[1];
        int totalMaxOR[]=new int[1];
        int n=nums.length;
        solve(0,nums,maxOR,totalMaxOR,0,n);
        return totalMaxOR[0];
        
    }
    private void solve(int curr,int nums[],int maxOR[],int totalMaxOR[],int currOR,int n)
    {
        if(curr==n)
        {
            if(currOR==maxOR[0])
                totalMaxOR[0]++;
            else if(currOR>maxOR[0])
            {
                totalMaxOR[0]=1;
                maxOR[0]=currOR;
            }
            return ;
        }
        solve(curr+1,nums,maxOR,totalMaxOR,currOR|nums[curr],n);
        solve(curr+1,nums,maxOR,totalMaxOR,currOR,n);
    }
}