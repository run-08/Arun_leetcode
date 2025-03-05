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
    int cnt = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
       findMin(root , 0);
       return cnt;
    }
    public void findMin(TreeNode root , int count){
        if(root == null){
            cnt = Math.min(cnt , count);
            return;
        }
        if((root.right == null && root.left == null) || (root.right != null && root.left != null)) {
            findMin(root.left , count+1);
            findMin(root.right , count+1);
        }
        else if(root.right == null) findMin(root.left , count+1);
        else  findMin(root.right , count+1);
    }
}