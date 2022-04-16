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
    HashMap<Integer,Integer>hs1 = new HashMap<>();
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        int prefixSum[] = new int[li.size()];
        int prev=0;
        for(int i=li.size()-1;i>=0;i--)
        {
            prefixSum[i]=prev+li.get(i);
            hs1.put(li.get(i),prefixSum[i]);
            prev=prefixSum[i];
            //System.out.println(li.get(i)+" "+hs1.get(li.get(i)));
        }
        modify(root);
        return root;
        
    }
    private void  traverse(TreeNode root)
    {
        if(root==null)
            return ;
        traverse(root.left);
        li.add(root.val);
        traverse(root.right);
    }
    private void modify(TreeNode root)
    {
        if(root==null)
            return;
        root.val=hs1.get(root.val);
        modify(root.left);
        modify(root.right);
    }
}