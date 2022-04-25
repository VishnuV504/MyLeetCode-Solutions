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
    int maxHeight=0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return maxHeight;   
    }
    private void solve(TreeNode root)
    {
        if(root==null) return ;
        int height= findHeight(root.left)+findHeight(root.right);
        solve(root.left);
        solve(root.right);
        maxHeight =Math.max(height,maxHeight);
     }
    private int findHeight(TreeNode root)
    {
        if(root==null) return 0;
        return 1+Math.max(findHeight(root.left),findHeight(root.right));
    }
}