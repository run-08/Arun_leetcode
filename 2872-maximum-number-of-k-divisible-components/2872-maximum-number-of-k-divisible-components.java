class Solution {
    int count=0;
    List<List<Integer>> edges;
    public int maxKDivisibleComponents(int n, int[][] graph, int[] values, int k) {
        edges = new ArrayList<>();
        for(int i=0;i<n;i++) edges.add(new ArrayList<>());
        for(int[] edge:graph) {
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,k,values);
        return count;
    }
    private int dfs(int node, int parent,int k,int[] values){
        int sum = values[node];
        for(int child : edges.get(node)){
            if(child==parent)continue;
            sum += dfs(child,node,k,values);
        }
        if(sum%k==0)count++;
        return sum%k;
    }
}