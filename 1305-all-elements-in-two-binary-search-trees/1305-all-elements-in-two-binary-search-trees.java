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
    List<Integer>li2= new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>result = new ArrayList<>();
        add(root1);
        add2(root2);
        //apply two pointer
        int i=0; int j=0;
        while(i<li.size() && j<li2.size())
        {
            if(li.get(i)<li2.get(j))
            {
                result.add(li.get(i));
                i++;
            }
            else
            {
                result.add(li2.get(j));
                j++;
            }
        }
        while(i<li.size())
        {
            result.add(li.get(i));
            i++;
        }
        while(j<li2.size())
        {
            result.add(li2.get(j));
            j++;
        }
        return result;
        
    }
    private void add(TreeNode root)
    {
        if(root==null)
            return ;
        add(root.left);
        li.add(root.val);
        add(root.right);
        return;
    }
    private void add2(TreeNode root)
    {
        if(root==null)
            return ;
        add2(root.left);
        li2.add(root.val);
        add2(root.right);
        return;
    }
}