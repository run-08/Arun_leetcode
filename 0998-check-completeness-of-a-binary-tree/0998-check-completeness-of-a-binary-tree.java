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
    public boolean isCompleteTree(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        int height = 1;
        while(!q.isEmpty()){
            boolean isNull = false;
            Queue<TreeNode> child = new LinkedList<>();
            boolean isPresent = false;
            while(!q.isEmpty()){
                TreeNode root = q.poll();
               if(isNull && root.left != null) return false; 
               if(root.left == null) isNull = true;
               else {
                child.offer(root.left);
                if(root.left.left != null || root.left.right != null) isPresent = true;
               }
               if(isNull && root.right != null) return false;
               if(root.right == null) isNull = true;
               else {
                child.offer(root.right);
                if(root.right.left != null || root.right.right != null) isPresent = true;
               }
            }
            int size = child.size();
            if(isPresent && isNull) return false;
            if(!isPresent) break;
            if(size  > 0){
                if(Math.pow(2 , height) != size) return false;
                height++;
                q = child;
            }
        }
        return true;
    }
}