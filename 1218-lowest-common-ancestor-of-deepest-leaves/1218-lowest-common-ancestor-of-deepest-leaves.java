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
    TreeNode res ;int max_height = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       dfs(root , 0);
       return res;
    }
    public int dfs(TreeNode root , int cnt) {
        if(root == null) return 0;
        int cnt1 = dfs(root.left , cnt+1);
        int cnt2 = dfs(root.right , cnt+1);
        int max_depth = Math.max(cnt1+1 , cnt2+1);
        if(cnt1 == cnt2) {
            if(max_height <= cnt+max_depth){
                 res = root;
                 max_height = cnt+max_depth;
            }
        }
        return max_depth;
    }
}