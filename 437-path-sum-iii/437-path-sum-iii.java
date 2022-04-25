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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
         totalWays(root,targetSum,false);
        return count;
        
    }
    private void totalWays(TreeNode root, int target,boolean flag)
    {
        if(root==null) return ;
        if(target==root.val) count++;
        totalWays(root.left,target-root.val,true);
        totalWays(root.right,target-root.val,true);
        if(flag==false)
        {
        totalWays(root.left,target,false);
        totalWays(root.right,target,false);
        }
    }
}