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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root.left == null) return root;
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode currentnode = q.poll();
                 ls.add(currentnode.val);
                temp.offer(currentnode);
            }
            int idx = ls.size()-1;
            while(!temp.isEmpty()){
                TreeNode currentnode = temp.poll();
                currentnode.val = ls.get(idx--);
                if(currentnode.left != null && currentnode.left.left != null ){
                    q.offer(currentnode.left.left);
                    q.offer(currentnode.left.right);
                    q.offer(currentnode.right.left);
                    q.offer(currentnode.right.right);
                }
            }
        }
        return root;
    }
}