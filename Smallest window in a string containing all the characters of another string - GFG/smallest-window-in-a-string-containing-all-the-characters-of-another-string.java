// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int a= s.length();
        int freq[]= new int[26]; int b= p.length();
        int freq2[]= new int[26];
        for(int i=0;i<b;i++)
        freq[p.charAt(i)-'a']++;
        int k=0; int minLength=Integer.MAX_VALUE;
        String ans="-1";
        for(int i=0;i<a;i++)
        {
            freq2[s.charAt(i)-'a']++;
            boolean flag=isEqual(freq,freq2);
            //System.out.println(flag+" "+i);
            while(flag)
            {
                if(freq2[s.charAt(k)-'a']-1>=freq[s.charAt(k)-'a'])
                {
                    freq2[s.charAt(k)-'a']--;
                }
                else break;
                k++;
            }
            
            if(flag)
            {
                if(i-k+1<minLength)
                {
                    ans=s.substring(k,i+1);
                    minLength=i-k+1;
                }
            }
            
        }
        return ans;
    }
    private static boolean isEqual(int freq[],int freq2[])
    {
        boolean flag=true;
        for(int j=0;j<26;j++)
        {
                if(freq2[j]<freq[j])
                {
                    flag=false;
                    break;
                }
        }
            if(flag) return true;
            return false;
    }
}