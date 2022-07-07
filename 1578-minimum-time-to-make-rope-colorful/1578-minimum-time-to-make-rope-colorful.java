class Solution {
    public int minCost(String colors, int[] neededTime) {
        //return solve(0,'A',colors,neededTime,-1);
        return solve(colors,neededTime);
        
    }
    
    //using recursion--TLE
    private int solve(int curr,char prev,String colors,int arr[],int prevScore){
        if(curr>=colors.length())return 0;
        int cons=0;
        if(prev==colors.charAt(curr)){
            cons=Math.min(prevScore+(solve(curr+1,colors.charAt(curr),colors,arr,arr[curr])),arr[curr]+solve(curr+1,colors.charAt(curr),colors,arr,prevScore));
        }
        else{
            cons=solve(curr+1,colors.charAt(curr),colors,arr,arr[curr]);
        }
        return cons;
    }
    //greedy
    private int solve(String s,int arr[]){
        int n=s.length(); int minTime=0; int total=0;
        char prev='@'; int prevScore=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prev==s.charAt(i)){
                prevScore=Math.max(prevScore,arr[i-1]);
                    total=arr[i-1]; 
                while(i<s.length()&&prev==s.charAt(i)){
                    prevScore=Math.max(prevScore,arr[i]);
                    total+=arr[i];
                    i++;
                }
                i--;
                minTime+=total-prevScore;
                prevScore=Integer.MIN_VALUE;
                total=0;
            } 
            else
                prev=s.charAt(i);
        }
        return minTime;
    }
}