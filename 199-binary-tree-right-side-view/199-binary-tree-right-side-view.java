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
    List<Integer>ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,1);
        return ans;
    }
    private void solve(TreeNode root,int level)
    {
        if(root==null) return;
        if(ans.size()<level)
            ans.add(root.val);
        else
            ans.set(level-1,root.val);
        solve(root.left,level+1);
        solve(root.right,level+1);
        
    }
}