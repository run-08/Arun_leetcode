class Solution {
    public int minimumTime(int[][] grid) {
        int row = grid.length , col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        if ((row > 1 && grid[1][0] > 1) && (col > 1 && grid[0][1] > 1)) return -1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        grid[0][0] = 0;
        pq.offer(new Node(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.row , c = node.col , t = node.time;
            if(r == row-1 && c == col-1) return t;
            if(visited[r][c])continue;
            visited[r][c] = true;
            if(r+1 < row && !visited[r+1][c]){
                if(t+1 >= grid[r+1][c]) pq.offer(new Node(r+1 , c , t+1));
                else {
                    int x = (grid[r+1][c] - t);
                    if(x % 2 == 0) x += 1;
                    pq.offer(new Node(r+1 , c , x+t));
                }
            }
             if(r-1 >= 0 && !visited[r-1][c]){
                if(t+1 >= grid[r-1][c]) pq.offer(new Node(r-1 , c , t+1));
                else {
                    int x = (grid[r-1][c] - t);
                    if(x % 2 == 0) x += 1;
                    pq.offer(new Node(r-1 , c , x+t));
                }
            }
            if(c-1 >= 0 && !visited[r][c-1]){
                if(t+1 >= grid[r][c-1]) pq.offer(new Node(r , c-1 , t+1));
                else {
                    int x = (grid[r][c-1] - t);
                    if(x % 2 == 0) x += 1;
                    pq.offer(new Node(r , c-1 , x+t));
                }
            }
             if(c+1 < col && !visited[r][c+1]){
                if(t+1 >= grid[r][c+1]) pq.offer(new Node(r , c+1 , 1+t));
                else {
                    int x = (grid[r][c+1] - t);
                    if(x % 2 == 0) x += 1;
                    pq.offer(new Node(r , c+1 , x+t));
                }
            }
        }
        return -1;
    }
    class Node implements Comparable<Node>{
        int row , col , time;
        public Node(int row , int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
        @Override
        public int compareTo(Node other){
            return this.time - other.time;
        }
    }
}