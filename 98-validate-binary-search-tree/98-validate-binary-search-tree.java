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
    public boolean isValidBST(TreeNode root) {
        solve(root);
        int n=ans.size();
        for(int i=1;i<n;i++)
            if(ans.get(i)<=ans.get(i-1)) return false;
        return true;
    }
    private void solve(TreeNode root)
    {
        if(root==null) return;
        solve(root.left);
        ans.add(root.val);
        solve(root.right);
    }
}
