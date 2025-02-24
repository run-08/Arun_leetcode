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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         if( root == null) return new ArrayList<>();
         List<List<Integer>> res = new ArrayList<>();
         bacres(root , targetSum , res , new ArrayList<>());
         return res;
    }
    public void bacres(TreeNode root , int target , List<List<Integer>> res , List<Integer> ls){  
        target -= root.val;
        ls.add(root.val);
        if(target == 0 && root.right == null && root.left == null){
           res.add(new ArrayList<>(ls));
           ls.remove(ls.size()-1);
           return;
        }
        if(root.left != null)  bacres(root.left ,target , res , ls);
        if(root.right != null) bacres(root.right , target , res , ls);
        if(ls.size() > 0) ls.remove(ls.size()-1);
        target += root.val;
    }
}