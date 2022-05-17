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
    HashMap<TreeNode,TreeNode>parents= new HashMap<>();
    HashMap<TreeNode,Boolean>visited = new HashMap<>();
    List<Integer>ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root,null);
        findNodesAtK(target,k);
        return ans; 
    }
    private void findParents(TreeNode root,TreeNode prev)
    {
        if(root==null) return;
        parents.put(root,prev);
        findParents(root.left,root);
        findParents(root.right,root);
    }
    private void findNodesAtK(TreeNode target,int k)
    {
        if(target==null||visited.containsKey(target)) return;
        visited.put(target,true);
        if(k==0) {
            ans.add(target.val);
            return;
        }
        findNodesAtK(target.left,k-1);
        findNodesAtK(target.right,k-1);
        findNodesAtK(parents.get(target),k-1);
    }
}