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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = postorder.length;
        for(int i = 0;i < n;i++) hm.put(postorder[i] , i);
        Queue<Integer> q = new LinkedList<>();
        for(int val : preorder) q.offer(val);
        return buildCompleteBinaryTree(hm , q , n);
    }
    public TreeNode buildCompleteBinaryTree(HashMap<Integer , Integer> hm , Queue<Integer> q , int prev_idx){
        if(q.isEmpty() || hm.get(q.peek()) > prev_idx) return null;
        int value = q.poll();
        TreeNode root =  new TreeNode(value);
        root.left = buildCompleteBinaryTree(hm , q , hm.get(value));
        root.right = buildCompleteBinaryTree(hm , q , hm.get(value));
        return root;
    }
}