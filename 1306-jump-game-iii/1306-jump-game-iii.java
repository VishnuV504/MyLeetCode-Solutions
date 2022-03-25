class Solution {
    public boolean canReach(int[] arr, int start) {
        int dp[]= new int[100000];
        Arrays.fill(dp,-1);
        return check(start,arr,dp);
        
    }
    private boolean check(int curr,int arr[],int dp[])
    {
        if(curr>=arr.length || curr<0)
            return false;
        if(arr[curr]==0)
            return true;
        if(dp[curr]!=-1)
        {
            if(dp[curr]==1)
                return true;
            return false;
        }
        boolean pick=false; boolean notPick=false;
        pick = check(curr+arr[curr],arr,dp);
        if(pick)
            dp[curr]=1;
        else
            dp[curr]=0;
        notPick= check(curr-arr[curr],arr,dp);
        if(notPick)
            dp[curr]=1;
        else
            dp[curr]=0;
        return pick||notPick;
    }
}