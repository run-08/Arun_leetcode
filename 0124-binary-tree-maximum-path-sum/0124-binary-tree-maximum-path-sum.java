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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs ( root );
        return maxPath;
    }
    private int dfs ( TreeNode root ) {
            if ( root == null ) return 0;
            int lp = dfs ( root.left ) , rp = dfs ( root.right )  ;
            if ( lp < 0 ) lp = 0;
            if  ( rp < 0 ) rp = 0;
            int sum = root.val + lp + rp;
            maxPath = Math.max ( maxPath , sum );
            return Math.max (lp , rp  ) + root.val;
    }
}