/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>li = new ArrayList<>();
        if(root==null) return li;
        Stack<TreeNode>st1 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty())
        {
            TreeNode a=st1.pop();
            li.add(a.val);
            if(a.right!=null)
            st1.push(a.right);
            if(a.left!=null)
            st1.push(a.left);
        }
        return li;
        
        
    }
}