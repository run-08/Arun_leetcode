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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        ListNode[] res = new ListNode[k];
        if(k >= count){
            int idx = 0;
             while(head != null){
                res[idx++] = new ListNode(head.val);
                head = head.next;
             }
             return res;
        }
        int addition = count % k;
        for(int i = 0;i < res.length;i++){
            int target = (addition <= 0) ? count / k : (count / k)+1; 
            addition--;
             cur = new ListNode(0);
             ListNode temp = cur;
            for(int j = 0;j < target;j++){
                cur.next = new ListNode(head.val);
                cur = cur.next;
                head = head.next;
            }
            res[i] = temp.next;
        }
        return res;
    }
}