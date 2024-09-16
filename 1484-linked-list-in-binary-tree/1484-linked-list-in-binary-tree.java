/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        while(head != null){
            ls.add(head.val);
            head = head.next;
        }
        return Traversal(0,ls,root);
    }
    public boolean Traversal(int index,List<Integer> ls,TreeNode root){
      if(root == null) return false;
    //   System.out.print(root.val);
      if(root.val == ls.get(index)) {
        if(checkisSubPath(index,ls,root)) return true;
      }
      return Traversal(index,ls,root.left) || Traversal(index,ls,root.right);
    }
    public boolean checkisSubPath(int index,List<Integer> ls,TreeNode root){
        // System.out.print(index+"\n");
        if(index == ls.size()) return true;
        if(root == null) return false;
        // System.out.print(root.val+"->"+"\n");
        if(root.val == ls.get(index)) return checkisSubPath (index+1,ls,root.left) || checkisSubPath(index+1,ls,root.right);
        else return false;  
    }
}