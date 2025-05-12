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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0 , dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        int sum = left+right+root.val;
        maxSum = Math.max(sum , maxSum);
        return Math.max(left , right)+root.val;
    }
}