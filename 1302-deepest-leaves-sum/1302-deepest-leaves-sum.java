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
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            int size=q.size(); sum=0;
            while(size!=0)
            {
                TreeNode curr=q.remove();
                sum+=curr.val;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                size--; 
            }
        }
        return sum;  
    }
}