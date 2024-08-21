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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode data = new TreeNode();
        bacres(root,val,data);
        return data.left;
    }
        public void bacres(TreeNode root,int val,TreeNode data){
            if(root == null) return;
         if(root.val == val ) {
             data.left = root;
              return;
         }
        if(data.left == null)bacres(root.left,val,data);
        if(data.left == null) bacres(root.right,val,data);
    }
}