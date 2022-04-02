// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  K = Integer.parseInt(read.readLine());
            int  N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<N;i++){
                for(int j = 0;j<N;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(N, K, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    long totalWays(int row, int col,int n, int target,int arr[][],long dp[][][])
    {
        if(row==n-1 && col==n-1)
        {
            if(target==arr[row][col])
            return 1;
            else
            return 0;
        }
        if(row>n-1 ||col>n-1)
        return 0;
        if (target<0)
        return 0;
        if(dp[row][col][target]!=-1)
        return dp[row][col][target];
        long right = totalWays(row,col+1,n,target-arr[row][col],arr,dp);
        long down = totalWays(row+1,col,n,target-arr[row][col],arr,dp);
        dp[row][col][target]=right+down;
        return dp[row][col][target];
    }
    long numberOfPath(int N, int K, int [][]arr) {
        // code here
        long dp[][][]=new long[N][N][K+1];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                for(int l=0;l<=K;l++)
                    dp[i][j][l]=-1;
        return totalWays(0,0,N,K,arr,dp);
    }
}