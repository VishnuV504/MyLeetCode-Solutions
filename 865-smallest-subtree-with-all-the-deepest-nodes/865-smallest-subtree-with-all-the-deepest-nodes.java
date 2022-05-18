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
    TreeNode LCA=new TreeNode(-1);
    int target=0; int maxLvl=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        lvlOrder(root);
        if(target!=1)solve(root,1);else solve2(root,1);
        return LCA;
    }
    private void lvlOrder(TreeNode root)
    {
        int count=0; int lvl=0;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            int size=q.size();  count=0;
            while(size!=0)   
            {
                count++;
                TreeNode curr=q.remove();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                size--;
            }
            lvl++;
        }
        target=count;
        maxLvl=lvl;
        return;
    }
    private int solve(TreeNode root,int depth)
    {
        if(root==null) return 0;
        if(depth==maxLvl) return 1;
        int left=solve(root.left,depth+1);
        int right=solve(root.right,depth+1);
        if(left+right==target) {LCA=root; return 100;}
        return left+right;
    }
    
    private void solve2(TreeNode root,int depth)
    {
         if(root==null) return;
        if(depth==maxLvl){LCA=root; return;}
        solve2(root.left,depth+1);
        solve2(root.right,depth+1);
    } 
}