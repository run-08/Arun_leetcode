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
    private int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = preorder.length;
        for(int i = 0;i < n;i++) hm.put(inorder[i] , i);
       return  buildCompleteBinaryTree(preorder , hm , 0 , n-1);
    }
    public TreeNode buildCompleteBinaryTree(int[] preOrder , HashMap<Integer , Integer> hm , int start , int end) {
        int n = preOrder.length;
        if((idx == n) || (start  < 0 || end < 0) || (start >= n || end >= n) ||start >  end ) return null;
        int index_in = hm.get(preOrder[idx]);
        if((index_in < start) || (index_in > end)) return null;
        int value = preOrder[idx++];
        TreeNode root = new TreeNode(value);
        root.left = buildCompleteBinaryTree(preOrder , hm , start , index_in-1);
        root.right = buildCompleteBinaryTree(preOrder , hm ,index_in+1 , end );
        return root;
    }
}