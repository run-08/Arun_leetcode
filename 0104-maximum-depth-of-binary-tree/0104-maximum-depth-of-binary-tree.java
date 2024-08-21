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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        q.add(new ArrayList<>(temp));
        int depth =0;
        while(!q.isEmpty()){
            List<TreeNode> Data = q.poll();
            List<TreeNode> Adder = new ArrayList<>();
            depth++;
            for(int i = 0;i < Data.size();i++){
                if(Data.get(i).left != null) Adder.add(Data.get(i).left);
                if(Data.get(i).right != null) Adder.add(Data.get(i).right);
           }
            System.out.print("\n");
            if(Adder.size() > 0) q.add(new ArrayList<>(Adder));
         }
        return depth;
    }
}