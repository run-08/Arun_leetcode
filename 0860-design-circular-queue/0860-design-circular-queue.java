class MyCircularQueue {
    Node root , cur;
    int size , n;
    public MyCircularQueue(int k) {
        this.size = k;
        n = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == n) return false;
        ++n;
        if(root == null) {
            root = new Node(value);
            cur = root;
        }
        else {
            cur.next = new Node(value);
            cur = cur.next;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(n == 0) return false;
        root = root.next;
        if(root == null) cur = null;
        --n;
        return true;
    }
    
    public int Front() {
        if(n == 0) return -1;
        return root.val;
    }
    
    public int Rear() {
        if(n == 0) return -1;
        return cur.val;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public boolean isFull() {
        return n == size;
    }
    class Node{
        int val;
        Node next;
        Node (int val){
            this.val = val;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */