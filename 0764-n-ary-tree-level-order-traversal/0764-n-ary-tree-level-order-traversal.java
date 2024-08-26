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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Node> temp = new ArrayList<>();
        temp.add(root);
        Queue<List<Node>> q = new LinkedList<>();
        q.offer(new ArrayList<>(temp));
        while(!q.isEmpty()){
             List<Node> Adder = new ArrayList<>();
             List<Integer> Data = new ArrayList<>();
             temp = q.poll();
             for(int i = 0;i < temp.size();i++){
                if(temp.get(i) == null) break;
                Data.add(temp.get(i).val);
                if(temp.get(i).children != null) Adder.addAll(temp.get(i).children);
             }
            res.add(new ArrayList<>(Data));
           if(Adder.size() > 0) q.offer(new ArrayList<>(Adder));
        }
        return res;
    }
}