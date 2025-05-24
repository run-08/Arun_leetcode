/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    HashMap<ListNode , Integer> hm;
    public ListNode detectCycle(ListNode head) {
        hm = new HashMap<>();
        int idx  = 0;
        if(head == null || head.next == null) return null;
        while(head != null) {
            if(hm.containsKey(head)) return head;
            hm.put(head , idx++);
            head = head.next;
        }
        return null;
    }
}