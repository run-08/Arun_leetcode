class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max =  0;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                Integer sum = 0;
                 if(visited[i][j] || grid[i][j] == 0) continue;
                  sum = bacres(grid , visited , i , j , sum);
                //   System.out.print(sum);
                 if(sum > max) max = sum;
            }
        }
        return max;
    }
    public int  bacres (int[][] grid , boolean[][] visited , int row , int col , Integer sum) {
         if(visited[row][col]  || grid[row][col] == 0) return sum;
         sum += grid[row][col];
         visited[row][col] = true;
         if(row+1 < grid.length)  sum = bacres(grid , visited , row+1 , col , sum);
         if(row-1 >= 0) sum =  bacres(grid , visited , row - 1 , col , sum);
         if(col-1 >= 0) sum =  bacres(grid , visited , row , col - 1 , sum);
         if(col+1 < grid[0].length) sum =  bacres(grid , visited , row , col + 1 , sum);
         return sum;
    }
}