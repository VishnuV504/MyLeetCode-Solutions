class Solution {
    //int dp[][]=new int[1001][2003];
    public int findLongestChain(int[][] pairs) {
        //Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        // for(int i=0;i<=1000;i++)
        //     Arrays.fill(dp[i],-1);
        // return solve(0,-1001,pairs);
        return solve(pairs);
    }
    // private int solve(int curr,int prev,int pairs[][]){
    //     if(curr==pairs.length)
    //         return 0;
    //     if(dp[curr][prev+1001]!=-1)return dp[curr][prev+1001];
    //     int cons=0;
    //     if(pairs[curr][0]>prev)
    //         cons=1+solve(curr+1,pairs[curr][1],pairs);
    //     int notCons=solve(curr+1,prev,pairs);
    //     return dp[curr][prev+1001]=Math.max(cons,notCons);
    // }
    private int solve(int pairs[][]){
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int prev=-1001;
        int maxLength=0;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>prev){
                maxLength++;
                prev=pairs[i][1];
            }
        }
        return maxLength;
    }
}