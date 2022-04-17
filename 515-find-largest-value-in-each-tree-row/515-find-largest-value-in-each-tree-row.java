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
    HashMap<Integer,Integer>hs1 = new LinkedHashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        find(root,0);
        for(Integer key : hs1.keySet())
            li.add(hs1.get(key));
        return li;
    }
    public void find(TreeNode root, int depth)
    {
        if(root==null) return;
        if(hs1.containsKey(depth))
        {
            if(hs1.get(depth)<root.val)
                hs1.put(depth,root.val);
        }
        if(!hs1.containsKey(depth))
            hs1.put(depth,root.val);
        find(root.left,depth+1);
        find(root.right,depth+1);
    }
}