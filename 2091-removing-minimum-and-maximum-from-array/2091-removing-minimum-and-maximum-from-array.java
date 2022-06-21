class Solution {
    public int minimumDeletions(int[] nums) {
        int x=Integer.MAX_VALUE; int n=nums.length;
        int y=Integer.MIN_VALUE; int xPos=-1; int yPos=-1;
        for(int i=0;i<n;i++){
            if(nums[i]<x){
                x=nums[i];
                xPos=i;
            }
            if(nums[i]>y){
                y=nums[i];
                yPos=i;
            }
        }
        int max=Math.max(xPos,yPos);
        int min=Math.min(xPos,yPos);
        return Math.min(1+max,Math.min(n-min,min+1+(n-max)));
        
    }
}