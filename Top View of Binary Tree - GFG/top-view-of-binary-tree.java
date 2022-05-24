// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class pair{
    Node a;
    char dir;
    int lvl;
    pair(Node node,char k,int l)
    {
       this. a=node;
        this.dir=k;
        this.lvl=l;
    }
}

class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<pair>q = new LinkedList<pair>();
        pair h=new pair(root,'l',0);
        q.add(h); 
         //System.out.println("hkhg");
        HashMap<Integer,Integer>hs1 = new HashMap<Integer,Integer>();
        while(q.size()!=0)
        {
            int size=q.size();
            // System.out.println("hkhg");
            while(size!=0)
            {
                Node m=q.peek().a;
                char di=q.peek().dir;
                int lv=q.peek().lvl;
                if(!hs1.containsKey(lv))
                hs1.put(lv,m.data);
                q.remove();
                if(m.left!=null)
                {
                    pair z=new pair(m.left,'l',lv-1);
                    q.add(z);
                }
                if(m.right!=null)
                {
                    pair z=new pair(m.right,'r',lv+1);
                    q.add(z);
                }
                //System.out.println("hkhg");
                size--;
            }
            
        }
         ArrayList<Integer>ans = new ArrayList<>();
        int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        for(Integer key : hs1.keySet())
        {
            min=Math.min(min,key);
            max=Math.max(max,key);
        }
        for(int i=min;i<=max;i++)
        {
            if(hs1.containsKey(i))
            ans.add(hs1.get(i));
        }
        return ans;
    }
}