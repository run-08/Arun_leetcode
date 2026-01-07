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
    private long max;
    private static final int MOD = 1_000_000_007;
    long totalSum;
    public int maxProduct(TreeNode root) {
        // let's sum all the values in a tree...
        totalSum = getSum(root);
        // Find maximum value...
        dfs(root);
        return (int)(max % MOD);
    }
    private long getSum(TreeNode root){
        if(root==null) return 0;
        return (long)root.val+getSum(root.left)+getSum(root.right);
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        max = Math.max(max,(totalSum-leftSum)*leftSum);
        max = Math.max(max,(totalSum-rightSum)*rightSum);
        return root.val+leftSum+rightSum;
    }
}