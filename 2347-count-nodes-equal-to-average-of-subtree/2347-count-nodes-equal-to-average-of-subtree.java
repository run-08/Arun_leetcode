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
    int good_nodes = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return good_nodes;
    }
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int val = root.val;
        int cnt_nodes =  dfs(root.left) + dfs(root.right)+ 1;
        root.val = root.val+(root.left != null ? root.left.val : 0)+(root.right != null ? root.right.val : 0);
        if(root.val / cnt_nodes == val)good_nodes++;
        return cnt_nodes;
    }
}