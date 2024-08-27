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
    public int goodNodes(TreeNode root) {
        int count[] = {0};
        int max = root.val;
        Traverse(root,count,max);
        return count[0];
    }
    public void Traverse(TreeNode root,int[] count,int max){
       if(root == null)return;
       if(root.val >= max){
        count[0] = count[0]+1;
        if(max < root.val) max = root.val;
       }
       Traverse(root.left,count,max);
       Traverse(root.right,count,max);
    }
}