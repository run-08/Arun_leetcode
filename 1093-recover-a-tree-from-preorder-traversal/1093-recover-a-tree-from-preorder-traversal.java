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
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(-1 , new StringBuilder(traversal));
    }
    public TreeNode dfs(int prev , StringBuilder s){
        int hyphen_count = 0;
        for(int i = 0;i < s.length() && s.charAt(i) == '-';i++) hyphen_count++;
        if(hyphen_count <= prev) return null;
        int value = 0;
        int val_cnt = 0;
        for(int i = hyphen_count ; i < s.length() && s.charAt(i) != '-';i++) {
            value = value*10+(s.charAt(i)-'0');
            val_cnt++;
        }
        s.delete(0,hyphen_count+val_cnt);
        TreeNode root = new TreeNode(value);
        root.left = dfs(hyphen_count , s);
        root.right = dfs(hyphen_count ,  s);
        return root;
    }
}