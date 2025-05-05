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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int group = 1;
        ListNode res = new ListNode();
        ListNode cur = res;
        while(head != null) {
            int cnt = 0;
            int val = head.val;
            ListNode reversed = new ListNode();
            ListNode node = reversed;
            for(int i = 0;i < group && head != null;i++) {
                node.next = new ListNode(head.val);
                node = node.next;
                head = head.next;
                cnt++;
            }
            group++;
            reversed = reversed.next;
            if((cnt & 1) == 0) {
                reversed = reverse(reversed);
            }
            cur.next = reversed;
            while(cur.next != null) cur = cur.next;
        }
        return res.next;
    }
    public ListNode reverse(ListNode reversed) {
        ListNode prev = null;
        ListNode rev = reversed;
        while(reversed != null) {
           ListNode next = reversed.next;
           reversed.next = prev;
           prev = reversed;
           reversed = next;
        }
        return  prev;
    }
}