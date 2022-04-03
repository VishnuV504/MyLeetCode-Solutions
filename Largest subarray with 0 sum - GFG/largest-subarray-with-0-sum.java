// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int prefixSum[] = new int[arr.length];
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        prefixSum[0]=arr[0]; int maxLength=0;
        hs1.put(prefixSum[0],0);
        for(int i=1;i<arr.length;i++)
        {
            prefixSum[i]=prefixSum[i-1]+arr[i];
            //System.out.println(prefixSum[i]);
            if(hs1.containsKey(prefixSum[i]))
            {
                int len=i-hs1.get(prefixSum[i]);
                if(len>maxLength)
                maxLength=len;
            }
            else
            hs1.put(prefixSum[i],i);
            if(prefixSum[i]==0)
            {
                if(i+1>maxLength)
                maxLength=i+1;
            }
            
        }
        return maxLength;
    }
}