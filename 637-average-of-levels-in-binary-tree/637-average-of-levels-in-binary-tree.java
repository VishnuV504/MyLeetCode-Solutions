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
    ArrayList<Double>ans = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        solve(root);
        return ans;
        
    }
    private void solve(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long lvlAvg=0; int count=0;
            while(size!=0){
                TreeNode curr=q.peek();
                lvlAvg+=curr.val;
                q.remove();
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                size--;
                count++;
            }
            ans.add(lvlAvg/(count*1.0));
            
        }
    }
}