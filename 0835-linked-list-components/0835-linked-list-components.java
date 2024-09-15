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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int val : nums) hs.add(val);
        int count = 0;
        while(head != null){
             if(hs.contains(head.val)){
                count++;
                while(head.next != null && hs.contains(head.next.val)) head = head.next;
             }
             head = head.next;
        }
        return count;
    }
}