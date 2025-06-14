/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
    //     while(result != null){
    //         if(result.child != null){
    //             Node next = result.next;
    //             result.next = result.child;
    //             result.child.prev = result;
    //             Node child = childConnect(result.child); 
    //             result.child = null;
    //             child.next = next;
    //             if(next != null)next.prev = child;
    //             result = child;
    //         }
    //         if(result != null) result = result.next;
    //     }
    //     return head;
    // }
    // private Node childConnect(Node current) {
    //     while( current.next != null ){
    //         if(current.child != null) {
    //             Node next = current.next;
    //             current.next = current.child;
    //             current.child.prev = current;
    //             Node child = childConnect(current.child);
    //             current.child = null;
    //             child.next = next;
    //             if(next != null)next.prev = child;
    //             current = child;
    //             if(current.next == null) return current; 
    //             current = current.next;
    //         }
    //         if(current != null && current.next != null) return current;
    //         current = current.next;
    //     }
    //     return current;
           Node cur = head;
           while(cur != null) {
               if(cur.child != null) {
                   Node depthChild = getDepthChild(cur.child);
                   Node next = cur.next;
                   cur.child.prev = cur;
                   cur.next = cur.child;
                   cur.child = null;
                   depthChild.next = next;
                   if(next != null) next.prev = depthChild;
               }
               cur = cur.next;
           }
           return head;
    }
    private Node getDepthChild(Node head) {
        while(head.next != null) head = head.next;
        return head;
    }
}