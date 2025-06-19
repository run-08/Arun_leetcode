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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.right , 1 , false);
        dfs(root.left , 1 , true);
        return max;
    }
    private void dfs(TreeNode root , int cnt , boolean isL) {
        if(root == null) return ;
        max = Math.max( max , cnt );
        if(root.left != null)  dfs( root.left , ((isL) ? 1 : cnt+1) , true);
        if(root.right != null) dfs( root.right , ((isL) ? cnt+1 : 1 ) , false );
    }
}