class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length , ConnectedGraphsCount = 0;
        boolean[] visited = new boolean[vertices];
        for( int vertice = 0;vertice < vertices;vertice++) {
            if(visited[vertice]) continue;
            visited[vertice] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(vertice);
            while(!q.isEmpty()) {
                int node = q.poll();
                int[] nodeChildren = isConnected[node];
                for( int i = 0;i < vertices;i++) {
                    if( nodeChildren[i] == 1 && !visited[i] ){
                        visited[i] = true;
                        q.offer(i);
                    }
                } 
            }
            ConnectedGraphsCount++;
        }
        return ConnectedGraphsCount;
    }
}