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
class CBTInserter {
      
    TreeNode root;
    Queue < TreeNode > childNodes = new ArrayDeque <> (); 
    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue < TreeNode > parentWithChildren = new ArrayDeque <> ();
        parentWithChildren.offer (this.root );
        while ( !parentWithChildren.isEmpty() ) {
            TreeNode node = parentWithChildren.poll();
            if ( node.left != null && node.right != null ) {
                parentWithChildren.offer ( node.left );
                parentWithChildren.offer ( node.right );
            }
            else childNodes.offer ( node );
        }
    }
    
    public int insert(int val) {
        TreeNode topNode = childNodes.peek();
        // System.out.print (topNode.val +"\n");
        if ( topNode.left == null ) topNode.left = new TreeNode ( val );
        else {
            topNode.right = new TreeNode ( val );
            childNodes.poll();
            childNodes.offer ( topNode.left );
            childNodes.offer ( topNode.right );
        }
        return topNode.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */