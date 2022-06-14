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
    int max=0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root,root.val,root.val);
        return max;
    }
    private void solve(TreeNode root,int maxVal,int minVal)
    {
        if(root==null) return;
        max=Math.max(max,Math.abs(maxVal-root.val));
        max=Math.max(max,Math.abs(minVal-root.val));
        solve(root.left,Math.max(maxVal,root.val),Math.min(minVal,root.val));
        solve(root.right,Math.max(maxVal,root.val),Math.min(minVal,root.val));
    }
}