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
    // if the freq of  digits from root to leaf path has more than 1 odd then that path is not pseudo palindromic
    int freq[]= new int[10];
    int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root);
        return count;  
    }
    private void solve(TreeNode root)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            int countOdd=0;
            freq[root.val]++;
            for(int i=1;i<10;i++)
            {
                if((freq[i]&1)==1) countOdd++;
                if(countOdd>1)
                {  
                    freq[root.val]--;
                    return ;
                }
            }
            freq[root.val]--;
            count++;
        }
        freq[root.val]++;
        solve(root.left);
        solve(root.right);
        freq[root.val]--;
    }
}