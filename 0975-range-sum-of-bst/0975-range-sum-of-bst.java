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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = {0};
        bacres(sum,root,low,high);
        return sum[0];
    }
    public void bacres(int[] sum,TreeNode root,int low,int high){
        if(root == null) return;
        if(root.val <= high && root.val >= low) sum[0] = sum[0]+root.val;
        bacres(sum,root.left,low,high);
         bacres(sum,root.right,low,high);
    }
}