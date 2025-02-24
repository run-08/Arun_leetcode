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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return bacres(root , targetSum);
    }
    public boolean bacres(TreeNode root , int target){
        target -= root.val;
        if(target == 0 && root.right == null && root.left == null)return true;
        if(root.left != null) if(bacres(root.left ,target)) return true;
        if(root.right != null) if(bacres(root.right , target)) return true;
        return false;
    }
}