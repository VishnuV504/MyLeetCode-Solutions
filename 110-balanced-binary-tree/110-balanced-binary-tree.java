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
    public boolean isBalanced(TreeNode root) {
        return solve(root);
    }
    private boolean solve(TreeNode root)
    {
        if(root==null)return true;
        int left = findHeight(root.left);
        int right=findHeight(root.right);
        if(Math.abs(left-right)>1) return false;
       return solve(root.left)&&solve(root.right);
    }
    private int findHeight(TreeNode root)
    {
        if(root==null) return 0;
        return 1+Math.max(findHeight(root.left),findHeight(root.right));
    }
}