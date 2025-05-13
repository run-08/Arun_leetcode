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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        dfs(root1 , r1);
        dfs(root2 , r2);
        int size1 = r1.size() ;
        if(size1 != r2.size()) return false;
        for(int i = 0;i < size1;i++) if(!(r1.get(i).equals(r2.get(i)))) return false;
        return true;
    }
    public void dfs(TreeNode root , List<Integer> ls){
        if(root == null) return;
        dfs(root.left , ls);
        if(root.left == null && root.right == null) ls.add(root.val);
        dfs(root.right , ls);
    }
}