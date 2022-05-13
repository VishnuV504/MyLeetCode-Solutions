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
                if(root==null) return root;
        Queue<Node>que = new LinkedList<Node>();
        que.add(root);
        while(que.size()!=0)
        {
            int size=que.size();
            while(size!=0)
            {
                Node curr=que.remove();
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
                size--;
                if(size!=0)
                curr.next=que.peek();
            }
        }
        return root;

        
    }
}