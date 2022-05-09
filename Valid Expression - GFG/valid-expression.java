// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        // code here
         int score1=0;int score2=0;int score3=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(score1<0||score2<0||score3<0) return false;
            if(s.charAt(i)=='(') ++score1;
            else if(s.charAt(i)=='{') ++score2;
            else if(s.charAt(i)=='[') ++score3;
            else if(s.charAt(i)==')') --score1;
            else if(s.charAt(i)=='}') --score2;
            else --score3; 
        }
        if(score1==0&&score2==0&&score3==0) return true;
        return false;
    }
} 