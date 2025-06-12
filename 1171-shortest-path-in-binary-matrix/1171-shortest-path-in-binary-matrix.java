class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int row = grid.length , col = grid[0].length;
        Queue<int[]> queue =  new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int r = arr[0] , c = arr[1];
            if(r == row-1 && col == c+1) return arr[2];
            if(r-1 >= 0 && grid[r-1][c] == 0 && !visited[r-1][c]) {
                visited[r-1][c] = true;
                queue.offer(new int[]{r-1 , c , arr[2]+1});
            }
            if(r+1 < row && grid[r+1][c] == 0 && !visited[r+1][c]) {
                visited[r+1][c] = true;
                queue.offer(new int[]{r+1 , c , arr[2]+1});
            }
            if(c+1 < col && grid[r][c+1] == 0 && !visited[r][c+1]) {
                visited[r][c+1] = true;
                queue.offer(new int[]{r , c+1 , arr[2]+1});
            }
            if(c-1 >= 0 && grid[r][c-1] == 0 && !visited[r][c-1]){
                visited[r][c-1] = true;
                queue.offer(new int[]{r , c-1 , arr[2]+1});
            }
            if(r-1 >= 0 && c-1 >= 0 && grid[r-1][c-1] == 0 && !visited[r-1][c-1]){
                visited[r-1][c-1] = true;
                queue.offer(new int[]{r-1 , c-1 , arr[2]+1});
            }
            if(r-1 >= 0 && c+1 < col && grid[r-1][c+1] == 0 && !visited[r-1][c+1]){
                  visited[r-1][c+1]= true;
                  queue.offer(new int[]{r-1,c+1 , arr[2]+1});
            }
            if(r+1 < row && c-1 >= 0 && grid[r+1][c-1] == 0 && !visited[r+1][c-1]){
                  visited[r+1][c-1] = true;
                  queue.offer(new int[]{r+1 , c-1 , arr[2]+1});
            }
            if(r+1 < row && c+1 < col && grid[r+1][c+1] == 0 && !visited[r+1][c+1]){
                 visited[r+1][c+1] = true;
                 queue.offer(new int[]{r+1 , c+1 , arr[2]+1});
            }
        }
        return -1;
    }
}