class Solution {
    int r , c;
    boolean visited[][];
    public void solve(char[][] grid) {
        r = grid.length ; c = grid[0].length;int xes = 0;
        visited = new boolean[r][c];
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(i != 0 && j != 0 && i != r-1 && j != c-1 ) continue;
                if(visited[i][j] || grid[i][j] == 'X') continue;
                visited[i][j] = true;
                 bfs( i , j , grid);
            }
        }
        for(int i = 0;i < r;i++) for(int j = 0;j < c;j++) grid[i][j] = visited[i][j] ? 'O' : 'X';
    }
    public void bfs(int row , int col , char[][] grid){
        if(row+1 < r && !visited[row+1][col] && grid[row+1][col] != 'X') {
              visited[row+1][col] = true;
              bfs(row+1 , col , grid);
        }
        if(col+1 < c && !visited[row][col+1] && grid[row][col+1] != 'X'){
            visited[row][col+1] = true;
            bfs(row , col+1 , grid);
         }
         if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col] != 'X'){
            visited[row-1][col] = true;
            bfs(row-1 , col , grid);
         }
        if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1] != 'X'){
            visited[row][col-1] = true;
            bfs(row , col-1 , grid);
        }
    }
}