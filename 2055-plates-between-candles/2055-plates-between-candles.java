class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();ArrayList<Integer>candles= new ArrayList<>();
        int prefixSum[]=new int[n]; if(s.charAt(0)=='*')prefixSum[0]=1;
        if(s.charAt(0)=='|')candles.add(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='*')
                prefixSum[i]=prefixSum[i-1]+1;
            else{
                prefixSum[i]=prefixSum[i-1];
                candles.add(i);
            }
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=sip(candles,queries[i][0]);
            int right=sip2(candles,queries[i][1]);
            //System.out.println(left+" "+right);
            if(left>=queries[i][0]&&right<=queries[i][1]&&left<right)
            ans[i]=prefixSum[right]-prefixSum[left];  
        }
        return ans;
        
        
    }
    private int sip(ArrayList<Integer>li,int target){
        int i=0; int j=li.size()-1; int pos=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(li.get(mid)==target) return li.get(mid);
            if(li.get(mid)<target) i=mid+1;
            else{
                pos=li.get(mid);
                j=mid-1;
            }
        }
        return pos;
    }
    private int sip2(ArrayList<Integer>li,int target){
        int i=0; int j=li.size()-1; int pos=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(li.get(mid)==target) return li.get(mid);
            if(li.get(mid)<target){ 
                i=mid+1;
                pos=li.get(mid);
            }
            else{
                j=mid-1;
            }
        }
        return pos;
    }
    

}