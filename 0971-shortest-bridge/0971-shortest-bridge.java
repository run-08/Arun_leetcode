class Solution {
    boolean[][] visited;
    int row , col , shortDistance = 101;
    public int shortestBridge(int[][] grid) {
        int r = grid.length , c = grid[0].length;
        this.row = r ; this.col = c;
        visited = new boolean[r][c];
        for(int i = 0;i < r;i++){
            boolean isOneMarked = false;
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    DFS(grid , i , j);
                    isOneMarked = true;
                    break;
                }
                else isOneMarked = false;
            }
            if(isOneMarked) break;
        }
        boolean[][] secondIsland = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    if(i-1 >= 0 && grid[i-1][j] == 0) q.add(new int[]{ i-1 , j , 1});
                    if(i+1 < row && grid[i+1][j] == 0) q.add(new int[]{i+1 , j , 1});
                    if(j - 1 >= 0 && grid[i][j-1] == 0) q.add(new int[]{i , j-1 , 1});
                    if(j + 1 < col && grid[i][j+1] == 0) q.add(new int[]{i , j+1 , 1});
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0] , j = arr[1] , cnt = arr[2];
            if(secondIsland[i][j]) continue;
            secondIsland[i][j] = true;
            if(grid[i][j] == 1 && visited[i][j]){
                shortDistance = Math.min( shortDistance , cnt);
                break;
            }
            if(i-1 >= 0 ) q.add(new int[]{ i-1 , j , cnt+1});
            if(i+1 < row ) q.add(new int[]{i+1 , j , cnt+1});
            if(j - 1 >= 0) q.add(new int[]{i , j-1 , cnt+1});
            if(j + 1 < col ) q.add(new int[]{i , j+1 , cnt+1});
        }
        return shortDistance-1;
    }
    private void DFS(int[][] grid , int r , int c ){
        if(grid[r][c] == 0) return;
        if(r+1 < row && grid[r+1][c] == 1 && !visited[r+1][c]){
            visited[r+1][c] = true;
            DFS(grid , r+1 , c);
        }
        if(r-1 >= 0 && grid[r-1][c] == 1 && !visited[r-1][c]){
            visited[r-1][c] = true;
            DFS(grid , r-1 , c);
        }
        if(c-1 >= 0 && grid[r][c-1] == 1 && !visited[r][c-1]){
            visited[r][c-1] = true;
            DFS(grid , r , c-1);
        }
        if(c+1 < col && grid[r][c+1] == 1 && !visited[r][c+1]){
            visited[r][c+1] = true;
            DFS(grid , r , c+1);
        }
    }

}