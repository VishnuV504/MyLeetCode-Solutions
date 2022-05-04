// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long count=0;
        int countOne=0;
        int countTwo=0; int countZero=0;
        HashMap<String,Integer>hs1 = new HashMap<>();
        String a="0"+"-"+"0";
        hs1.put(a,1); int n= str.length();
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)=='0')
            countZero++;
            else if(str.charAt(i)=='1')
            countOne++;
            else
            countTwo++;
            int b= countZero-countOne;
            int c=countOne-countTwo;
            String curr=b+"-"+c;
            if(hs1.containsKey(curr))
            {
                count+=hs1.get(curr);
                hs1.put(curr,hs1.get(curr)+1);
            }
            else
            hs1.put(curr,1);
        }
        return count;
    }
} 