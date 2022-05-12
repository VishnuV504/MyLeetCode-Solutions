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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans= new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode>queue =new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0)
        {
            int lvlSize=queue.size();
            List<Integer>li =new ArrayList<>();
            while(lvlSize!=0)
            {
                TreeNode curr=queue.peek();
                    queue.remove();
                li.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                lvlSize--;
            }
            ans.add(0,li);
        }
        return ans;  
    }
}