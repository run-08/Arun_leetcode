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
    List < TreeNode > Forest;
    List < Integer > neededToDelete = new ArrayList <> ();
    public List< TreeNode > delNodes ( TreeNode root, int[] to_delete ) {
        Forest = new ArrayList <> ();
        for ( int tree : to_delete ) neededToDelete.add ( tree );
        if ( root == null ) return Forest;
        dfs ( root );
        if ( !neededToDelete.contains ( root.val ) ) Forest.add ( root );
        return Forest;
    }
    private TreeNode dfs ( TreeNode root ) {
        
        if ( root == null ||  ( neededToDelete.contains ( root.val) && root.right == null && root.left == null ) ) return null;
       root.left = dfs ( root.left );
       root.right = dfs ( root.right );
       if (neededToDelete.contains ( root.val ) ) {
         if ( root.left != null ) Forest.add( root.left );
         if ( root.right != null ) Forest.add( root.right );
         return null;
       }
        return root;
    }
}