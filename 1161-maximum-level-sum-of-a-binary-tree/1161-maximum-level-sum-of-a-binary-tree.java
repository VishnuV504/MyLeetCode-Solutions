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
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer>li = new ArrayList<>();
        max(root,1,li);
        int maxSum=Integer.MIN_VALUE;
        int maxLevel=0;
        for(int i=0;i<li.size();i++)
        {
            if(li.get(i)>maxSum)
            {
                maxSum=li.get(i);
                maxLevel=i+1;
            }
        }
        return maxLevel;
        
    }
    private void max(TreeNode root,int level,ArrayList<Integer>li)
    {
        if(root==null) return ;
        if(level<=li.size()) li.set(level-1,li.get(level-1)+root.val);
        else li.add(root.val);
        max(root.left,level+1,li);
        max(root.right,level+1,li);
    }
}