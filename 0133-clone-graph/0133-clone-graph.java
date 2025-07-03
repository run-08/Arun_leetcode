/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node , Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        return  dfs(node);
    }
    private Node dfs( Node node) {
          if(map.containsKey(node)) return map.get(node);
          Node copiedNode = new Node(node.val);
          map.put(node , copiedNode);
          for( Node child : node.neighbors) copiedNode.neighbors.add(dfs( child ));
          return copiedNode;
    }
}