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
    public int maxDepth(Node root) {
        return dfs ( root );
    }
    private int dfs ( Node root ) {
        if ( root == null ) return 0;
        int max = 0;
        List < Node > children = root.children;
        if ( children == null ) return 0;
        for ( Node child : children ) max = Math.max ( dfs ( child ) , max );
        return max + 1;
    }
}