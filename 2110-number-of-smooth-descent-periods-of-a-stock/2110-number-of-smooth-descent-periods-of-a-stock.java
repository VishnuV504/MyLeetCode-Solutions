class Solution {
    public long getDescentPeriods(int[] prices) {
        int prev=prices[0]+1; int n=prices.length; int j=0;
        long total=0;
        for(int i=0;i<n;i++){
            if(prices[i]+1==prev){
                total+=i-j+1;
                prev=prices[i];
            }
            else{
                total++;
                prev=prices[i];
                j=i;
            }
        }
        return total;
    }
}