/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode ,  TreeNode> hm = new HashMap<>();
        hm.put(root , null);
        dfs(root , hm);
        List<TreeNode> ls = new ArrayList<>();
        TreeNode s = p;
        while(s != null) {
            ls.add(s);
            s = hm.get(s);
        }
        s = q;
        while(!ls.contains(s)) s = hm.get(s);
        return s;
    }
     public void dfs(TreeNode root , HashMap<TreeNode , TreeNode> hm){
        if(root == null) return;
        if(root.left != null) hm.put(root.left , root);
        if(root.right != null) hm.put(root.right , root);
        dfs(root.left , hm);
        dfs(root.right , hm);
     }

}