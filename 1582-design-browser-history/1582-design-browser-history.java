class BrowserHistory {
    Node root;
    public BrowserHistory(String homepage) {
        root = new Node(homepage);
    }
    
    public void visit(String url) {
        root.next = new Node(url);
        root.next.prev = root;
        root = root.next;
    }
    
    public String back(int steps) {
        while(steps != 0 && root.prev != null) {
            steps--;
            root = root.prev;
        }
        return root.url;
    }
    
    public String forward(int steps) {
        while(steps != 0 && root.next != null){
            steps--;
            root = root.next;
        }
        return root.url;
    }
}
class Node{
    String url;
    Node next;
    Node prev;
    public Node(){

    }
    public Node(String url){
        this.url = url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */