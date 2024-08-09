/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<List<Node>> q =new LinkedList<>();
        List<Node> data = new ArrayList<>();
        data.add(root);
        q.add(data);
        while(!q.isEmpty()){
            List<Node>  ls = q.poll();
            List<Node> value = new ArrayList<>();
            for(int i = 0;i < ls.size();i++){
                Node root_node = ls.get(i);
                if(root_node == null)continue;
                if(root_node.left != null)value.add(root_node.left);
                if(root_node.right != null) value.add(root_node.right);
                if(i+1 >= ls.size()) root_node.next= null;
                else {
                    Node adjacent_node = ls.get(i+1);
                    root_node.next = adjacent_node;
                } 
            }
            if(value.size() > 0) q.offer(value);
        }
        return root;
    }
}