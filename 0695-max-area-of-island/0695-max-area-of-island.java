class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxAreaisland = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length ;j++){
                if(grid[i][j] == 0 || visited[i][j] == 1)continue;
                visited[i][j] = 1;
                int count = FindMax(i , j , 1 , visited , grid);
                if(count > maxAreaisland) maxAreaisland = count;
            }
        }
        return maxAreaisland;
    }
    public int FindMax(int row , int col , int count , int[][] visited , int[][]grid){

        if(row > -1 && row < grid.length){
            if((col -1 > -1) && grid[row][col-1] == 1 && visited[row][col-1] != 1){
                  visited[row][col-1] = 1;
                  count = FindMax(row , col -1 , ++count , visited , grid);
            }
            if((col + 1) < grid[0].length && grid[row][col+1] == 1  && visited[row][col+1] != 1){
                visited[row][col+1] = 1;
                count = FindMax(row , col + 1 , ++count , visited , grid);
            }
        }
        if(col < grid[0].length && col > -1){
            if((row - 1) > -1 && grid[row-1][col] == 1  && visited[row-1][col] != 1){
                visited[row-1][col] = 1;
                count = FindMax(row - 1 , col , ++count , visited , grid);
            }
            if((row + 1) < grid.length && grid[row+1][col] == 1  && visited[row+1][col] != 1){
                visited[row+1][col] = 1;
                count = FindMax(row + 1 , col , ++count , visited , grid);
            }
        }
        return count;
    }
}