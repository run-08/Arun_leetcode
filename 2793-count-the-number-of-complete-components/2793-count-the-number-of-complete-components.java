class Solution {
    boolean[] visited;
    List<List<Integer>> transitiveNeighbors;
    public int countCompleteComponents(int n, int[][] edges) {
        visited = new boolean[n];
        transitiveNeighbors = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            List<Integer> neighbor = new ArrayList<>();
            neighbor.add(i);
            transitiveNeighbors.add(neighbor);
        }
        for(int[] edge : edges){
            transitiveNeighbors.get(edge[0]).add(edge[1]);
            transitiveNeighbors.get(edge[1]).add(edge[0]);
        }
        // Do DFS
        Queue<List<Integer>> components = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i , component);
                components.add(component);
            }
        }
        int connectedComponent = 0;
        while(!components.isEmpty()){
           List<Integer> component = components.poll();
           boolean isCommon = true;
           for(int noOfEdges : component) if(transitiveNeighbors.get(noOfEdges).size() != component.size()) isCommon = false;
           if(isCommon) connectedComponent++;
        }
        return connectedComponent;
    }
    private void dfs(int node , List<Integer> component){
        if(visited[node]) return;
        visited[node] = true;
        component.add(node);
        for(int child : transitiveNeighbors.get(node)){
            if(!visited[child]) dfs(child , component);
        }

    }
}