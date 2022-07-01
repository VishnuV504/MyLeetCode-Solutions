class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans=0; int n=boxTypes.length;
        PriorityQueue<int[]>pq= new PriorityQueue<int[]>(((a, b) -> b[0] - a[0]));
        for(int i=0;i<n;i++){
            int arr[]=new int[2];
            arr[0]=boxTypes[i][1];
            arr[1]=boxTypes[i][0];
            pq.add(arr);
        }
        while(!pq.isEmpty()){
            //System.out.println(pq.peek()[0]+" "+pq.peek()[1]);
            if(truckSize>=pq.peek()[1]){
                ans+=(pq.peek()[0])*(pq.peek()[1]);
                truckSize-=pq.peek()[1];
                pq.remove();
            }
            else{
                if(truckSize==0) return ans;
                else{
                    ans+=truckSize*pq.peek()[0];
                    pq.remove();
                    truckSize=0;  
                }
            }
                
        }
        return ans;
    }
}