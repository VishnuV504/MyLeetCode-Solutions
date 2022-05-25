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
class pair{
    TreeNode curr;
    int lvl;
    pair(TreeNode curr,int lvl)
    {
        this.curr=curr;
        this.lvl=lvl;
    }
}
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
       // return solve(root);
        //return bfs(root);
        return dfs(root);
    }
    public int solve(TreeNode root)
    {
        if(root==null) return 1000000;
        if(root.left==null && root.right==null)return 1;
        return 1+Math.min(solve(root.left),solve(root.right));
    }
    public int bfs(TreeNode root)
    {
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root); int minLvl=1;
        while(q.size()!=0)
        {
            int size=q.size();
            while(size!=0)
            {
                TreeNode curr=q.peek();
                q.remove();
                if(curr.left==null && curr.right==null)return minLvl;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                size--;
            }
            minLvl++;
        }
        return minLvl;
    }
    public int dfs(TreeNode root)
    {
        Stack<pair>st1 = new Stack<>();
        st1.push(new pair(root,1));
        int minLvl=Integer.MAX_VALUE;
        while(!st1.isEmpty())
        {
            TreeNode curr=st1.peek().curr;
            int lvl=st1.peek().lvl;
            st1.pop();
            if(curr.left==null&& curr.right==null) minLvl=Math.min(minLvl,lvl);
            if(curr.left!=null) st1.push(new pair(curr.left,lvl+1));
            if(curr.right!=null)st1.push(new pair(curr.right,lvl+1));
        }
        return minLvl;
    }
    
}