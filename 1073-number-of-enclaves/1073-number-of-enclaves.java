class Solution {
    boolean visited[][];
    int r , c , visitedOnes = 0;
    public int numEnclaves(int[][] grid) {
        r = grid.length ; c = grid[0].length;int ones = 0;
        for(int[] arr : grid) for(int val : arr) if( (val & 1) != 0)ones++;
        visited = new boolean[r][c];
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if((i != 0 && j != 0) && (i != r-1 && j != c-1)) continue;
                if(visited[i][j] || grid[i][j] == 0) continue;
                visited[i][j] = true;
                 bfs( i , j , grid);
            }
        }
        return ones - visitedOnes;
    }
    public void bfs(int row , int col , int[][] grid){
        if(grid[row][col] == 1 ) visitedOnes++;
        if(row+1 < r && !visited[row+1][col] && grid[row+1][col] != 0) {
              visited[row+1][col] = true;
              bfs(row+1 , col , grid);
        }
        if(col+1 < c && !visited[row][col+1] && grid[row][col+1] != 0){
            visited[row][col+1] = true;
            bfs(row , col+1 , grid);
         }
         if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col] != 0){
            visited[row-1][col] = true;
            bfs(row-1 , col , grid);
         }
        if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1] != 0){
            visited[row][col-1] = true;
            bfs(row , col-1 , grid);
        }
    }
}