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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return li;
       // solve(root,li);
        solve(root,0);
        return li;
        
    }
    private void solve(TreeNode root,List<Integer>li){
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int num=-1000;
            while(size!=0){
                TreeNode curr=q.peek();
                q.remove();
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                num=curr.val;
                size--;
                    
            }
            if(num!=-1000)
                li.add(num);
        }
    }
    private void solve(TreeNode root,int depth){
        if(root==null)return ;
        if(li.size()==depth)li.add(root.val);
        else if(li.size()>depth)
            li.set(depth,root.val);
        solve(root.left,depth+1);
        solve(root.right,depth+1);
        
        
    }
}
