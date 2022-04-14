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
    List<Integer>li = new ArrayList<>();
    List<Integer>li2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        check1(root1);
        check2(root2);
        if(li.size()!=li2.size())
            return false;
        for(int i=0;i<li.size();i++)
        {
            //System.out.println(li.get(i)+" "+li2.get(i));
            if(li.get(i)!=li2.get(i))
            return false;
        }
        return true; 
    }
    private void check1(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left==null&& root.right==null)
        {
            li.add(root.val);
            return;
        }
        check1(root.left);
        check1(root.right);
        return;
    }
    private void check2(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            li2.add(root.val);
            return;
        }
        check2(root.left);
        check2(root.right);
        return;
    }
}