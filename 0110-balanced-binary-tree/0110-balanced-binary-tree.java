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
    public boolean isBalanced(TreeNode root) {
       if ( root == null ) return true;
       return checkBalance ( root ) != -1;   
    }
    private int checkBalance ( TreeNode root ) {
        if ( root == null ) return 0;
        int leftPath = checkBalance ( root.left );
        int rightPath = checkBalance ( root.right );
        if (  leftPath == -1  || rightPath == -1 ||  Math.abs ( leftPath - rightPath ) > 1 ) return -1;
        return Math.max ( leftPath , rightPath ) + 1;
    }

}