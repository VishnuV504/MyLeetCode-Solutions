class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length; int size=0;
        int arr[]= new int[n+n]; int sum=0; int j=n-k;
        fill(0,arr,cardPoints); int maxSum=0;
        fill(n,arr,cardPoints);
        for(int i=n-k;i<n+k;i++){
            sum+=arr[i];size++;
            if(size==k){
                maxSum=Math.max(sum,maxSum);
                //System.out.println(sum);
                sum-=arr[j];
                j++;
                size--;
            }
        }
        return maxSum;
    }
    private void fill(int j ,int arr[],int cardPoints[]){
            for(int i=0;i<cardPoints.length;i++)
            arr[j++]=cardPoints[i];
    }
}