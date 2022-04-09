// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(hs1.containsKey(arr[i]))
            hs1.put(arr[i],hs1.get(arr[i])+1);
            else
            hs1.put(arr[i],1);
        }
        // 2 3 3 1 2 3
        int freq[] = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            freq[i]=hs1.get(arr[i]);
            //System.out.println(freq[i]);
        }
        
        int[] result= new int[arr.length];
        Stack<Integer>st1 = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(st1.size()==0)
                result[i]=-1;
            else if(freq[st1.peek()]>freq[i])
                result[i]=arr[st1.peek()];
            else
            {
                while(st1.size()!=0 && freq[st1.peek()]<=freq[i])
                {
                    st1.pop();
                }
                if(st1.size()==0)
                    result[i]=-1;
                else
                    result[i]=arr[st1.peek()];
            }
            st1.push(i);
        }
        return result;
    }
}

