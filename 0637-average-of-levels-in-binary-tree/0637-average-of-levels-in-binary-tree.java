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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        q.offer(temp);
        while(!q.isEmpty()){
            List<TreeNode> Data = q.poll();
            List<TreeNode> Adder = new ArrayList<>();
            double sum = 0;
            int level = 0;
            for(int i = 0;i < Data.size();i++){
                level++;
                sum += Data.get(i).val;
                if(Data.get(i).left != null) Adder.add(Data.get(i).left);
                if(Data.get(i).right != null) Adder.add(Data.get(i).right);
            }
            sum = sum/level;
            if(Adder.size() > 0) q.offer(new ArrayList<>(Adder));
            result.add(sum);
        }
        return result;
    }
}