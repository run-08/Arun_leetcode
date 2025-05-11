class Solution {
    public int swimInWater(int[][] grid) {
        int row = grid.length , col = grid[0].length;
         boolean[][] visited = new boolean[row][col];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,grid[0][0]));
        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.row;
            int c = node.col;
            int time = node.time;
            max = Math.max(max , time);
            if(r == row-1 && c == col-1) return max;
            if(visited[r][c])continue;
            visited[r][c] = true;
             if(r+1 < row && !visited[r+1][c]) pq.offer(new Node(r+1 , c , grid[r+1][c]));
            if(r-1 >= 0 && !visited[r-1][c]) pq.offer(new Node(r-1 , c , grid[r-1][c]));
            if(c+1 < col && !visited[r][c+1]) pq.offer(new Node(r , c+1 , grid[r][c+1]));
            if(c-1 >= 0 && !visited[r][c-1]) pq.offer(new Node(r, c-1 , grid[r][c-1]));
        }
        return -1;
    }
   class Node implements Comparable<Node>{
        int row , time, col;
        Node(int row , int col ,int time ) {
            this.row = row;
            this.time = time;
            this.col = col;
        }
        @Override
        public int compareTo(Node other){
            return this.time - other.time;
        }
    }
}