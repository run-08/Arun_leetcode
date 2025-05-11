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
    int max = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max != Integer.MIN_VALUE ? max : 0;
    }
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{-1001 , 0};
        }
        int cnt = 0;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if(left[0] == root.val) cnt = Math.max(cnt , left[1]);
        if(right[0] == root.val) cnt = Math.max(cnt , right[1]);
        if(left[0] == root.val && right[0] == root.val) max = Math.max(left[1]+right[1] , max);
        else if(right[0] == root.val)  max = Math.max(right[1] , max);
        else if(left[0] == root.val)  max = Math.max(left[1] , max);
        return new int[]{root.val , cnt+1};
    }
}