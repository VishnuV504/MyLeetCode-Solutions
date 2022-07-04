// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	for(int i=0;i<n;i++){
    	    int count=0; int count2=0;
    	    for(int j=0;j<n;j++){
    	        if(M[j][i]==1)count++;
    	        if(M[i][j]==1)count2++;
    	    }
    	    //System.out.println
    	    if(count==n-1&&count2==0)
    	    return i;
    	    
    	}
    	return -1;
    }
}