class Solution {
    public boolean checkPossibility(int[] nums) {
    int k=1; int n=nums.length; int prev=Integer.MAX_VALUE;
        boolean flag=true; int index=-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<=prev){
                prev=nums[i];
            }
            else if(k==1){
                k=0;
                index=i;
            }
            else 
                flag=false; 
        }
        if(flag==true) return true;
        if(index+2<n)
        prev=nums[index+2];
        else prev=Integer.MAX_VALUE;
        if(index!=-1){
            for(int i=index;i>=0;i--){
                if(nums[i]<=prev){
                    prev=nums[i];
                }
                else
                    return false;
            }
        }
        return true;    
    }
}