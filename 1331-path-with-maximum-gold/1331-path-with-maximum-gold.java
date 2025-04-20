class Solution {
    int max = Integer.MIN_VALUE , r ,c;
    public int getMaximumGold(int[][] grid) {
        int res = 0 , row = grid.length , col = grid[0].length;
        r = row ; c = col; 
        for(int i = 0;i < row;i++){
           for(int j  = 0;j < col;j++){
               if(grid[i][j] != 0) {
                   boolean[][] visited = new boolean[row][col];
                   visited[i][j] = true;
                   dfs(visited , i , j , grid , grid[i][j]);
                   res = Math.max(max , res);
                   max = Integer.MIN_VALUE;
               }
           }
        }
        return res;
    }
    public void dfs(boolean[][] visited , int row , int col , int[][] grid , int cnt){
        max = Math.max(max , cnt);
        if(row+1 < r && !visited[row+1][col] && grid[row+1][col] != 0){
            visited[row+1][col] = true;
            dfs(visited , row+1 , col , grid , cnt+grid[row+1][col]);
            visited[row+1][col] = false;
        }
         if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col] != 0){
            visited[row-1][col] = true;
            dfs(visited , row-1 , col , grid , cnt+grid[row-1][col]);
              visited[row-1][col] = false;
        }
         if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1] != 0){
            visited[row][col-1] = true;
            dfs(visited , row , col-1 , grid , cnt+grid[row][col-1]);
            visited[row][col-1] = false;
        }
        if(col+1 < c && !visited[row][col+1] && grid[row][col+1] != 0){
            visited[row][col+1] = true;
            dfs(visited , row , col+1 , grid , cnt+grid[row][col+1]);
            visited[row][col+1] = false;
        }
    }
}