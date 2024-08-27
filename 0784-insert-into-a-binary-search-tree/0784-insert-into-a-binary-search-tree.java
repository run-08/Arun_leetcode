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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return Traverse(root,val);
    }
    public TreeNode Traverse(TreeNode root,int Data){
        if(root == null) return new TreeNode(Data);
        if(root.val > Data) root.left = Traverse(root.left,Data);
        if(root.val < Data) root.right = Traverse(root.right,Data);
        return root;
    }
}