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
    StringBuilder min=new StringBuilder("zzzzzzzzzzzzzzzzzzzzzzzz");
    StringBuilder curr=new StringBuilder();
    public String smallestFromLeaf(TreeNode root) { 
       solve(root);
        return min.toString();
    }
    private void solve(TreeNode root)
    {
        if(root==null)
        return;
        if(root.left==null && root.right==null)
        {
            curr.append((char)(97+root.val));
            //System.out.println(curr);
            curr.reverse();
            if(min.compareTo(curr)>0)
            {
                min.setLength(0);
                min.append(curr.toString());
                // System.out.println(min+" hoo");
                // System.out.println(curr+ " hm");
            }
            curr.reverse();
            curr.deleteCharAt(curr.length()-1);
            return;
        }
        curr.append((char)(97+root.val));
        solve(root.left);
        solve(root.right);
        curr.deleteCharAt(curr.length()-1);
    }
}