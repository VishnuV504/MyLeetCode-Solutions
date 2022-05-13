/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        /* using bfs*/
        // if(root==null) return root;
        // Queue<Node>que = new LinkedList<Node>();
        // que.add(root);
        // while(que.size()!=0)
        // {
        //     int size=que.size();
        //     while(size!=0)
        //     {
        //         Node curr=que.remove();
        //         if(curr.left!=null)
        //             que.add(curr.left);
        //         if(curr.right!=null)
        //             que.add(curr.right);
        //         size--;
        //         if(size!=0)
        //         curr.next=que.peek();
        //     }
        // }
        // return root;
        dfs(root,1);
        return root;  
    }
    
    // using dfs
    List<Node>ans = new ArrayList<Node>();
    private void dfs(Node root,int lvl)
    {
        if(root==null) return;
        if(ans.size()<lvl)
            ans.add(root);
        else
        {
            ans.get(lvl-1).next=root;
            ans.set(lvl-1,root);
        }
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);
    }
}