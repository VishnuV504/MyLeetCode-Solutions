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
    List<TreeNode>pPath= new ArrayList<>();
    List<TreeNode>qPath= new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root,p,new ArrayList<TreeNode>(),1);
        solve(root,q,new ArrayList<TreeNode>(),2);
        TreeNode LCA=new TreeNode(-1); int j=0; int i=0;
        while(i<pPath.size()&&j<qPath.size()){
            if(pPath.get(i)==qPath.get(j))
            {
                LCA=pPath.get(i);
                i++; j++;
            }
            else break;
        }
        return LCA;   
    }
    private void solve(TreeNode root,TreeNode val,List<TreeNode>path,int count)
    {
        if(root==null) return;
        if(root==val)
        {
            path.add(root);
            if(count==1) 
                for(int i=0;i<path.size();i++)pPath.add(path.get(i));
            else
                for(int i=0;i<path.size();i++)qPath.add(path.get(i));
            return;
        }
        path.add(root);
        solve(root.left,val,path,count);
        solve(root.right,val,path,count);
        path.remove(path.size()-1);
    }
}