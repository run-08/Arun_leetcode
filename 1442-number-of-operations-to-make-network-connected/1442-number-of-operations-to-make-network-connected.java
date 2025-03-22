class Solution {
    int[] parent , rank;
    public int makeConnected(int n, int[][] connections) {
        parent  = new int[n];
        rank = new int[n];
        for(int i = 0;i < n;i++) parent[i] = i;
        if(connections.length < n-1) return -1;
        for(int[] arr : connections) union(arr[0] , arr[1]);
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < n;i++) hs.add(find(i));
        // System.out.print(Arrays.toString(parent));
        return hs.size()-1;
    }
    public void union(int node1 , int node2) {
          int node1Parent = find(node1);
          int node2Parent = find(node2);
          if(node2Parent == node1Parent) return;
          if(rank[node2Parent] > rank[node1Parent]) parent[node1Parent] = node2Parent;
          else if(rank[node2Parent] < rank[node1Parent]) parent[node2Parent] = node1Parent;
          else {
            parent[node2Parent] = node1Parent;
            ++rank[node1Parent]; 
          }
    }
    public int find(int node) {
        if(node == parent[node]) return node;
        // path Compresssion
        parent[node] = find(parent[node]);
        return parent[node];
    }
}