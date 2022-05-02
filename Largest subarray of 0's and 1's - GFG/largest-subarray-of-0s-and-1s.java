// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends




class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        // Your code here
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            arr[i]=-1;
        }
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        //hs1.put(0,-1);
        int prefixSum=0; int max=0;
        for(int i=0;i<arr.length;i++)
        {
            prefixSum+=arr[i];
            if(prefixSum==0)
            max=Math.max(max,i+1);
            else if(hs1.containsKey(prefixSum))
            max=Math.max(max,i-hs1.get(prefixSum));
            else
            hs1.put(prefixSum,i);
            
        }
        return max;
        
    }
}
