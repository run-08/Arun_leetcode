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
    public long kthLargestLevelSum(TreeNode root, int k) {
      List<Long> ls = new ArrayList<>();
        List<List<TreeNode>> iterator= new ArrayList<>();
        List<TreeNode> tree = new ArrayList<>();
        tree.add(root);
        iterator.add(tree);
        while(iterator.size() > 0){
            List<TreeNode> data = new ArrayList<>();
            long sum = 0;
            List<TreeNode> val = iterator.remove(0);
            for(int i = 0;i < val.size();i++){
                sum += val.get(i).val;
               if(val.get(i).left != null) data.add(val.get(i).left);
                if(val.get(i). right != null) data.add(val.get(i).right);
                }
            if(data.size() > 0)iterator.add(data);
            ls.add(sum);
            }
        Collections.sort(ls);
        long res = 0;

        if(k > ls.size()) return -1;
        res = ls.get(ls.size() - k);
                     
        return res;
    }
}