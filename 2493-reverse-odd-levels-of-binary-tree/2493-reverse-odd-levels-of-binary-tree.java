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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        q.offer(temp);
        while(!q.isEmpty()){
            List<Integer> swaper = new ArrayList<>();
            List<TreeNode> Data = q.poll();
            List<TreeNode> Adder = new ArrayList<>();
            for(int i = 0;i < Data.size();i++){
                // System.out.print(Data.get(i).val);
                 if(Data.get(i).left != null) swaper.add(Data.get(i).left.val);
                 if(Data.get(i).right != null) swaper.add(Data.get(i).right.val);
            }
            int index = 0;
            for(int i = 0;i < Data.size();i++){
                if(Data.get(i).left != null) {
                    Data.get(i).left.val = swaper.get(swaper.size()-(index++)-1);
                   if(Data.get(i).left.left != null) Adder.add(Data.get(i).left.left);
                   if(Data.get(i).left.right != null) Adder.add(Data.get(i).left.right);
                }
             if(Data.get(i).right != null){
                 Data.get(i).right.val = swaper.get(swaper.size()-(index++)-1);
                 if(Data.get(i).right.left != null) Adder.add(Data.get(i).right.left);
                   if(Data.get(i).right.right != null) Adder.add(Data.get(i).right.right);
             }
            }
            if(Adder.size() > 0)q.offer(new ArrayList<>(Adder));
        }
        return root;
    }
}