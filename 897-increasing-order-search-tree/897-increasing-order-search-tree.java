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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result= new TreeNode(-1);
        curr=result;
        degen(root);
        return result.right;
        
    }
    private void degen(TreeNode root)
    {
        if(root==null)
            return ;
        degen(root.left);
        curr.right =new TreeNode(root.val);
        curr=curr.right;
        degen(root.right);
        return ;
    }
}