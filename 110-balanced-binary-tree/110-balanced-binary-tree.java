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
        if(findHeight(root)==-1)return false;
        return true;
    }
    private int findHeight(TreeNode root)
    {
        if(root==null) return 0;
        int left=findHeight(root.left);
        int right=findHeight(root.right);
        if(Math.abs(left-right)>1) return -1; // not a balanced bst 
        if(left==-1||right==-1) return -1;// if one this is -1 just return not a complete bst
        return 1+Math.max(left,right);
    }
}