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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return solve(root);
        
    }
    public int solve(TreeNode root)
    {
        if(root==null) return 1000000;
        if(root.left==null && root.right==null)return 1;
        return 1+Math.min(solve(root.left),solve(root.right));
    }
}