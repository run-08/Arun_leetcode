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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        HashMap hm = new HashMap();
        for(int i = 0;i < nums.length;i++)hm.put(nums[i],i);
        while(head  != null){
            if(hm.containsKey(head.val)){
                head = head.next;
                continue;
            }
            cur.next = new ListNode(head.val);
            cur = cur.next;
            head = head.next;
        }
        return res.next;
    }
}