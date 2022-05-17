/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = new TreeNode(-1);
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // solve(original,cloned,target);
        // return ans;
        return solve2(original,cloned,target);    
    }
    private void solve(TreeNode original,TreeNode clones,TreeNode target)
    {
        //recursive dfs
        if(original==null){return;}
        if(original==target){ans=clones; return;}
        solve(original.left,clones.left,target);
        solve(original.right,clones.right,target);
        return;
    }
    private TreeNode solve2(TreeNode original,TreeNode clone,TreeNode target)
    {
        //iterative dfs
        Stack<Pair<TreeNode,TreeNode>>st1 = new Stack<Pair<TreeNode,TreeNode>>();
        st1.push(new Pair<>(original,clone));
        while(st1.size()!=0)
        {
            TreeNode curr1=st1.peek().getKey();
            TreeNode curr2=st1.peek().getValue();
            st1.pop();
            if(curr1==target) return curr2;
            if(curr1.right!=null)
            st1.push(new Pair<>(curr1.right,curr2.right)); 
            if(curr1.left!=null)
            st1.push(new Pair<>(curr1.left,curr2.left));
        }
        return null;
    }
}