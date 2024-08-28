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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return  Traverse(root,target);
    }
    public TreeNode Traverse(TreeNode root,int tar){
      if(root == null) return root;
      root.left = Traverse(root.left,tar);
      if(root.val == tar && (root.left == null && root.right == null)) {
        root = null;
        return root;
      }
      root.right = Traverse(root.right,tar);
       if(root.val == tar && (root.left == null && root.right == null))  root = null;
      return root;
    }
}