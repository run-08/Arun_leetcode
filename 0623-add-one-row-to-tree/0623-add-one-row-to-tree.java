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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> tree = new ArrayList<>();
        tree.add(root);
        q.offer(tree);
        if(depth == 1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        int depther = 2;
        while(!q.isEmpty()){
            List<TreeNode> Adder = new ArrayList<>();
            List<TreeNode> Data = q.poll();
            for(int i = 0;i < Data.size();i++){ 
                 if(depther == depth){
                     TreeNode temp= new TreeNode(val);
                     if(Data.get(i).left != null){
                         temp.left = Data.get(i).left;
                         Data.get(i).left = temp;
                    }
                     else Data.get(i).left = temp;
                     temp = new TreeNode(val);
                     if(Data.get(i).right != null){
                         temp.right = Data.get(i).right;
                         Data.get(i).right = temp;
                     }
                     else Data.get(i).right = temp;
                     continue;
                  }
                   if(depther > depth) break;
                if(Data.get(i).left != null) Adder.add(Data.get(i).left);
                if(Data.get(i).right != null)Adder.add(Data.get(i).right);
            }
            depther++;
            if(Adder.size() > 0) q.offer(Adder);
            }
        return root;
    }
}