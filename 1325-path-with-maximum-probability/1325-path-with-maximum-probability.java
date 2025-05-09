class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> ls = new ArrayList<>();
        for(int i = 0;i < n;i++) ls.add(new ArrayList<>());
        int idx = 0;
        for(int[] arr : edges){
            ls.get(arr[0]).add(new Edge(arr[1],succProb[idx]));
            ls.get(arr[1]).add(new Edge(arr[0],succProb[idx]));
            idx++;
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start_node,1));
        while(!pq.isEmpty()){
           Node node = pq.poll();
           int u = node.node;
           double weight = node.weight;
           if(u == end_node) return weight;
           if(visited[u])continue;
           visited[u] = true;
           for(Edge edge : ls.get(u)){
             if(!visited[edge.edge]) pq.offer(new Node(edge.edge , weight*edge.weight));
           }
        }
        return 0;
    }
    class Node implements Comparable<Node>{
        int node;
        double weight;
        Node(int node , double weight){
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return Double.compare(o.weight , this.weight);
        }
    }
    class Edge{
        int edge ;double weight;
        Edge(int edge , double weight){
            this.edge = edge;
            this.weight = weight;
        }
    }
}