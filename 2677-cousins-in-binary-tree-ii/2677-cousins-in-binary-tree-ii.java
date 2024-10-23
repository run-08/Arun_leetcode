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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> ls = new ArrayList<>();
        ls.add(root);
        q.offer(new ArrayList<>(ls));
        while(q.size() > 0){
            List<TreeNode> iterator = q.poll();
            if(iterator.size() <= 0) continue;
            List<TreeNode> Data = new ArrayList<>();
            long sum = 0;
            for(int i = 0;i < iterator.size();i++){
               if(iterator.get(i).left != null) {
                sum += iterator.get(i).left.val;
                Data.add(iterator.get(i).left);
               }
               if(iterator.get(i).right != null){
                sum += iterator.get(i).right.val;
                Data.add(iterator.get(i).right);
               }
            }
            for(int i = 0;i < iterator.size();i++){
                int right = (iterator.get(i).right != null) ? iterator.get(i).right.val : 0;
                int left = (iterator.get(i).left != null) ? iterator.get(i).left.val : 0;
                if(iterator.get(i).left != null) iterator.get(i).left.val = (int)sum - (iterator.get(i).left.val+right);
                if(iterator.get(i).right != null) iterator.get(i).right.val = (int)sum - (iterator.get(i).right.val+left);
            }
            if(Data.size() > 0) q.offer(new ArrayList<>(Data));
        }
        root.val = 0;
        return root;
    }
}