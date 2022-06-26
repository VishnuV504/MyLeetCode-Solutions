class Solution {
    public int trap(int[] height) {
        int n=height.length; int maxL=0; int maxR=0;
        int ngl[]= new int[n]; int ngr[]= new int[n];
        for(int i=n-1;i>=0;i--){
            ngr[i]=maxR;
            maxR=Math.max(maxR,height[i]);
        }
        for(int i=0;i<n;i++){
            ngl[i]=maxL;
            maxL=Math.max(maxL,height[i]);
        }
        int sum=0;
        for(int i=1;i<n-1;i++){
           int min=Math.min(ngl[i],ngr[i]);
            if(min>height[i]){
                sum+=min-height[i];
            }
        }
        return sum;
    }
}