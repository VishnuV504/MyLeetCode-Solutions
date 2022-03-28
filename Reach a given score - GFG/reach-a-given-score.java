// { Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}// } Driver Code Ends


// Complete this function!

class Geeks {
    private long count2(int n,long dp[][],int arr[],int curr,int currSum)
    {
        if(currSum==n)
        return 1;
        else if(currSum>n || curr>=arr.length)
        return 0;
        else if(dp[curr][currSum]!=0)
        return dp[curr][currSum];
        long a= count2(n, dp, arr, curr, currSum+arr[curr]);
        long b= count2(n, dp, arr, curr+1, currSum);
        dp[curr][currSum]=a+b;
        return dp[curr][currSum];
    }
    public long count(int n) {
        long[][] dp = new long[3][n+1];
        int arr[] = {3,5,10};
        return count2(n,dp,arr,0,0);
    }
}