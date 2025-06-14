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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap hm = new HashMap();
        if(head == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                   hm.put(count++,cur.val);
            }
            cur = cur.next;
        }
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while(head != null){
            if(hm.containsValue(head.val)){
                head = head.next;
                continue;
            }
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }
        return res.next;
    }
}