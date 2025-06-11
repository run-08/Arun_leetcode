class MyLinkedList {
     Node head = null , tail = null;
     int size;
    public MyLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        if( index >= size ) return -1;
        if(index == size-1) return tail.val;
        if(index == 0) return head.val; 
        Node cur = head;
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            tail = head;
            size += 1;
            return;
        }
        Node root = new Node(val);
        root.next = head;
        head = root;
        size += 1;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            tail = head;
            size += 1;
            return;
        }
        tail.next = new Node(val);
        size += 1;
        tail = tail.next;
    }
    
    public void addAtIndex(int index, int val) {
        if( index > size ) return;
        if(head == null && size == 0) {
            size = 1;
            head = new Node(val);
            tail = head;
        }
        if(index == 0) {
            Node root = new Node(val);
            root.next = head;
            head = root;
            size += 1;
            return;
        }
        if(index == size) {
            tail.next = new Node(val);
            tail = tail.next;
            size += 1;
            return;
        }
        size += 1;
        Node cur = head;
        for(int i = 0;i < index-1;i++) {
            cur = cur.next;
        }
        Node temp = new Node(val);
        temp.next = cur.next;
        cur.next  = temp;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        size -= 1;
        if(index == 0) head = head.next;
        else {
            Node cur = head;
            for(int i = 0;i < index-1;i++) {
                cur = cur.next;
            }
            if(cur.next != null && cur.next.next != null){
                cur.next = cur.next.next;
            }
            else {
                tail = cur;
                tail.next = null;
            }
        }
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */