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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs ( root , 0 );
        return totalSum ;
    }
    private void dfs ( TreeNode root , int sum ) {
       if ( root.right != null && root.left != null ) {
            dfs( root.left , sum * 10 + root.val );
            dfs( root.right , sum * 10 + root.val );
       }
       else if ( root.right == null && root.left == null ) totalSum += sum * 10 + root.val ;
       else if ( root.right != null )  dfs( root.right , sum * 10 + root.val );
       else  dfs( root.left , sum * 10 + root.val ); 
    }
}