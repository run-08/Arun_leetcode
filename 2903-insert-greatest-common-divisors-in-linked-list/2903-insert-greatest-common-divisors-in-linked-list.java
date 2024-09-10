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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode next;
        ListNode res = new ListNode(0);
        ListNode result = res;
     
        while(head.next != null){
            res.next = new ListNode(head.val);
  
            res = res.next;
            int a = head.val;
            head = head.next;

          int b = head.val;
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
                }
            int rem = 1;

            while(rem != 0){
                rem = a % b;
                  a = b;
                  b = rem;
                }
            res.next = new ListNode(a);
    

        
            res = res.next;
            }
            res.next = new ListNode(head.val);
        return result.next;
    }
}