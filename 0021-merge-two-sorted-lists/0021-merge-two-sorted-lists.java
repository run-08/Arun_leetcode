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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> ls= new ArrayList<>();
        while (list1 != null){
            ls.add(list1.val);
            list1 = list1.next;   
        }
        while (list2 != null){
            ls.add(list2.val);
            list2 = list2.next;
    }   
    Collections.sort(ls);
    ListNode res = new ListNode();
    ListNode cur = res;
    while(ls.size() > 0){
        res.next = new ListNode(ls.remove(0));
        res = res.next;
    }
    return cur.next;

 }
    
}