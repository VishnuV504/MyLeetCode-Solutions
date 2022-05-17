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
    TreeNode ans = new TreeNode(-1);
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        solve(original,cloned,target);
        return ans;
        
    }
    private void solve(TreeNode original,TreeNode clones,TreeNode target)
    {
        if(original==null){return;}
        if(original==target){ans=clones; return;}
        solve(original.left,clones.left,target);
        solve(original.right,clones.right,target);
        return;
    }
}