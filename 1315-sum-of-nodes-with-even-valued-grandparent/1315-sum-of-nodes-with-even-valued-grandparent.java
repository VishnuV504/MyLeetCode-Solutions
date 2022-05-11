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
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        solve(root,-1,-2);
        return sum;
        
    }
    private void solve(TreeNode root,int prev,int prevPrev)
    {
        if(root==null) return;
        if(prevPrev>0 && (prevPrev&1)==0)sum+=root.val;
        solve(root.left,root.val,prev);
        solve(root.right,root.val,prev);
    }
}
