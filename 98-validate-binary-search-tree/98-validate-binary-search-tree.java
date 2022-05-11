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
    long prev=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
      return solve(root);
    }
    private boolean solve(TreeNode root)
    {
        if(root==null) return true;
        boolean left=solve(root.left);
        boolean mid=true;
        if(root.val<=prev) mid=false;
        else prev=root.val;
        boolean right=solve(root.right);
        return left&&right&&mid;
        
    }
}
