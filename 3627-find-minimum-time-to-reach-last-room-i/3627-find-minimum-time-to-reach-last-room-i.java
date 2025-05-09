class Solution {
    boolean[][] visited;
    public int minTimeToReach(int[][] moveTime) {
        return dijkstras(moveTime);
    }
    class Node implements Comparable<Node>{
        int row , col , distance;
        Node(int row , int col , int distance ){
            this.row = row;
            this.distance = distance;
            this.col = col;
        }
        @Override
        public int compareTo(Node other){
            return this.distance - other.distance;
        }
    }
    public int dijkstras(int[][] grid){
        int row = grid.length , col = grid[0].length;
        visited = new boolean[row][col];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.row , c = node.col;
            if(r == row-1 && c == col-1) return node.distance;
            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(r+1 < row && !visited[r+1][c]){
                 int x = node.distance;
                 if(node.distance < grid[r+1][c]) x += grid[r+1][c] - node.distance; 
                 pq.offer(new Node(r+1 , c , x+1));
            }
            if(r-1 >= 0 && !visited[r-1][c]) {
                 int x = node.distance;
                if(node.distance < grid[r-1][c]) x += grid[r-1][c] - node.distance; 
                pq.offer(new Node(r-1 , c , x+1));
            }
            if(c+1 < col && !visited[r][c+1]) {
                 int x = node.distance;
                if(node.distance < grid[r][c+1]) x += grid[r][c+1] - node.distance; 
                pq.offer(new Node(r , c+1 , x+1));
            }
            if(c-1 >= 0 && !visited[r][c-1]) {
                 int x = node.distance;
                if(node.distance < grid[r][c-1]) x += grid[r][c-1] - node.distance; 
                pq.offer(new Node(r , c-1 , x+1));
            }
        }
        return -1;
    }
}