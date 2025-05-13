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
    List<Integer> nodes = new ArrayList<>();
    int idx;
    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        Collections.sort(nodes);
        // System.out.print(nodes);
        idx = -1;
        setInOrderTraversal(root);
    }
    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        nodes.add(root.val);
        inOrderTraversal(root.right);
    }
    public void setInOrderTraversal(TreeNode root){
        if(root == null) return;
        setInOrderTraversal(root.left);
        root.val = nodes.get(++idx);
        setInOrderTraversal(root.right);
    }
}