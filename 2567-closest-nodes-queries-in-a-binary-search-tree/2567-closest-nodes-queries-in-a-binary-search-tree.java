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
    List<Integer> array = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        //System.out.print(array);
        List<List<Integer>> res = new ArrayList<>();
        int n = array.size();
        for(int data : queries){
            
            int s = 0;
            int e = n - 1;
            while(s <= e){
                int m = s + ( e - s ) / 2;
                int val = array.get(m);
                if(val == data){
                    s = m;
                    e = m;
                    break;
                }
                else if(val > data) e = m - 1;
                else s = m + 1;
            }
        res.add(List.of((e < n && e >= 0 ) ? array.get(e) : -1 ,(s < n && s >= 0) ?  array.get(s) : -1));
    }
    return res;
  }
    public void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        array.add(root.val);
        dfs(root.right);
        }
}