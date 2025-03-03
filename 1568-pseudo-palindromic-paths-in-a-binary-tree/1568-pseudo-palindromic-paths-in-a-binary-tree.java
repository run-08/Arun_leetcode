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
    int cnt = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        dfs(root , arr);
        return cnt;
    }
    public void dfs(TreeNode root , int[] arr){
        arr[root.val] += 1;
        if(root.left != null)dfs(root.left , arr);
        if(root.right != null) dfs(root.right , arr);
        if(root.right == null && root.left == null) {
            int odd_cnt = 0;
            for(int val : arr) if((val & 1) == 1) odd_cnt++;
            if(odd_cnt <= 1) cnt++;
        }
        arr[root.val] -= 1;
    }
}