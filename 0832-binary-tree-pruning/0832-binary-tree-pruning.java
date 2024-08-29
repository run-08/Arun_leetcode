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
    public TreeNode pruneTree(TreeNode root) {
        return Traverse(root);
    }
    public TreeNode Traverse(TreeNode root){
        if(root == null) return root;
       root.left =   Traverse(root.left);
        root.right =  Traverse(root.right);
        if(root.val == 0 && (root.right == null && root.left == null)) root = null;
        return root;
    }
}