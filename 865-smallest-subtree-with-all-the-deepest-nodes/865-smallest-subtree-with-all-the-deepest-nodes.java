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
    //it's like find deepest nodes and find lowest common ancestor
    // brute force find deepest nodes and check for everynode  is that node contain all the nodes which are deepest and find the lowest one than mean LCA
    int maxLvl=0;
    HashMap<Integer,Integer>hs1 = new HashMap<>();
    TreeNode curr= new TreeNode(1);
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDepthNodes(root,0);
        findLcs(root);
        return curr;
    }
    private void findDepthNodes(TreeNode root,int lvl)
    {
        if(root==null) return;
        if(lvl>maxLvl)
        {
            hs1.clear();
            maxLvl=lvl;
            hs1.put(root.val,1);
        }
        else if(maxLvl==lvl)
            hs1.put(root.val,1);
        findDepthNodes(root.left,lvl+1);
        findDepthNodes(root.right,lvl+1);
    }
    int count=0; boolean flag=false;
    private void findLcs(TreeNode root)
    {
        if(root==null) return;
        count=0; flag=false;
        isLcs(root);
        if(flag==true)
            curr=root;
        findLcs(root.left);
        findLcs(root.right);
    }
    private void isLcs(TreeNode root)
    {
        if(root==null) return;
        if(hs1.containsKey(root.val)) count++;
        if(count==hs1.size()) flag=true;
        isLcs(root.left);
        isLcs(root.right);  
    }
}