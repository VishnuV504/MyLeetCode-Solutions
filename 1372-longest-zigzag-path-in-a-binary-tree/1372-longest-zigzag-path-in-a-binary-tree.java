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
    public int longestZigZag(TreeNode root) {
        HashMap<String,Integer>dp = new HashMap<>();
        return solve(root,0,dp,false)-1;
    }
    private int solve(TreeNode root, int prev,HashMap<String,Integer>dp,boolean flag)
    {
        if(root==null) return 0;
        String currKey=root+"-"+prev;
        if(dp.containsKey(currKey))
            return dp.get(currKey);
        int left=0;int right=0;int noneLeft=0;int noneRight=0;
        if(prev!=1)
            right=1+solve(root.right,1,dp,true);
        if(prev!=2)
            left=1+solve(root.left,2,dp,true);
        if(flag==false)
        {
            noneLeft=solve(root.left,prev,dp,false);
            noneRight=solve(root.right,prev,dp,false);
        }
        int max=Math.max(noneLeft,noneRight);
        dp.put(currKey,Math.max(left,Math.max(right,max)));
        return dp.get(currKey);
    }
}