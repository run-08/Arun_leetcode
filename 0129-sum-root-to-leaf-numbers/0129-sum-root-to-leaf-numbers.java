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
    int res ;
    public int sumNumbers(TreeNode root) {
         res = 0;
         dfs(root , "");
         return res;
    }
    public void dfs(TreeNode root , String sum ){
        if(root.left == null && root.right == null) {
            res += Integer.parseInt(sum+String.valueOf(root.val));
            return;
        }
        if(root.left != null) dfs(root.left,sum+String.valueOf(root.val));
        if(root.right != null) dfs(root.right , sum+String.valueOf(root.val));
    }
}