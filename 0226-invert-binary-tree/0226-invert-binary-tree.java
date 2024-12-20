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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null || (root.left == null && root.right == null)) return root;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode currentnode = q.poll();
            TreeNode swap = currentnode.left;
            currentnode.left  =  currentnode.right;
            currentnode.right = swap;
            if(currentnode.left != null)q.offer(currentnode.left);
            if(currentnode.right != null)q.offer(currentnode.right);
        }
        return root;
    }
}