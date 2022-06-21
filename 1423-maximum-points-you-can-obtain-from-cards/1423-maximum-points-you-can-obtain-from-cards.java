class Solution {
    public int maxScore(int[] cardPoints, int m) {
        int n=cardPoints.length;
        int arr[]= new int[n+n]; int k=0;
        for(int i=0;i<n;i++)
            arr[k++]=cardPoints[i];
        for(int i=0;i<n;i++)
            arr[k++]=cardPoints[i];
        int sum=0;
        for(int i=n-m;i<n;i++){
            sum+=arr[i];
        }
        int maxSum=sum;
        int j=n-m; int l=n;
        while(j<n){
            sum-=arr[j];
            sum+=arr[l];
            j++;l++;
            //System.out.println(sum);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}