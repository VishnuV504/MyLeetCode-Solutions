// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer>hs1 = new HashMap<>();
        int j=0; int maxLength=0; int n=s.length();
        for(int i=0;i<n;i++)
        {
            Character curr = s.charAt(i);
            while(!hs1.containsKey(curr)&&hs1.size()==k)
            {
                if(hs1.get(s.charAt(j))==1)
                hs1.remove(s.charAt(j));
                else
                hs1.put(s.charAt(j),hs1.get(s.charAt(j))-1);
                j++;
            }
            if(hs1.containsKey(curr))
            hs1.put(curr,hs1.get(curr)+1);
            else
            {
            hs1.put(curr,1);
            }
            if(hs1.size()==k)
            maxLength=Math.max(maxLength,i-j+1);
            
        }
        if(maxLength==0) return -1;
        return maxLength;
    }
}