class Solution {
    int n;
    public int lenLongestFibSubseq(int[] arr) {
        n=arr.length;
        //int ans=solve(0,0,0,arr);
        // return (ans>2)?ans:0;
        //solve(arr));
        return solve2(arr);
    }
    private int solve(int curr,int prev,int prevPrev,int arr[]){
        if(curr==n)return 0;
        int cons=0;
        if(prevPrev==0||prev+prevPrev==arr[curr])
            cons=1+solve(curr+1,arr[curr],prev,arr);
        int notCons=solve(curr+1,prev,prevPrev,arr);
        return Math.max(cons,notCons);
        
    }
    private int solve(int arr[]){
        int len=2; int maxLen=2;
         for(int i=0;i<n;i++){
             int prevPrev=arr[i]; int temp=prevPrev;
             for(int j=i+1;j<n;j++){
                 int prev=arr[j]; len=2;
                 for(int k=j+1;k<n;k++){
                     if(prev+prevPrev==arr[k]){
                         len++;
                         prevPrev=prev;
                         prev=arr[k];
                     }     
                 }
                 prevPrev=temp;
                 maxLen=Math.max(len,maxLen); 
             }
         }
        return (maxLen>2)?maxLen:0;
    }
    private int solve2(int arr[]){
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        for(int i=0;i<n;i++) 
            hs1.put(arr[i],1);
        int len=2; int maxLen=2;
         for(int i=0;i<n;i++){
             int prevPrev=arr[i]; int temp2=prevPrev;
             for(int j=i+1;j<n;j++){
                 int prev=arr[j]; len=2;
                 while(hs1.containsKey(prev+prevPrev)){
                     len++;
                     int temp=prevPrev+prev;
                     prevPrev=prev;
                     prev=temp;
                 }
                 maxLen=Math.max(len,maxLen);
                 prevPrev=temp2;
             }
        }
        return (maxLen>2)?maxLen:0;
    }
}