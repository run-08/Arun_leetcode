/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        postOrder(ls,root);
        ls.add(root.val);
        return ls;
    }
    public void postOrder(List<Integer> ls,Node root){
        if(root.children == null) return;
        List<Node> childrens = root.children;
        for(int i = 0;i < childrens.size();i++){
           postOrder(ls,childrens.get(i));
            ls.add(childrens.get(i).val);
        }
    }
}