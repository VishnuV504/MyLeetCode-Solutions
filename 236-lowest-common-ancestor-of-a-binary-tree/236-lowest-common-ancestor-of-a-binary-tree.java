/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
    private  TreeNode solve(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null) return null;
        if(root==p) return p;
        if(root==q) return q;
        TreeNode left=solve(root.left,p,q);
        TreeNode right=solve(root.right,p,q);
        if(left!=null&&right!=null) return root;
        return (left==null)?right:left;
    }
}