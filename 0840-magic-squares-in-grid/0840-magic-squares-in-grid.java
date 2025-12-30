class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length,cnt=0;
        if(m*n < 9) return 0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                //    row checking...
                if(isMagic(i,j,grid)) cnt++;
            }
        }
        return cnt;
    }
    private boolean isMagic(int r,int c,int[][] grid){
        boolean distinct[] = new boolean[10];
        int value = -1;
        // check conditions...
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i+r][c+j] <= 0 || grid[i+r][c+j] > 9 || distinct[grid[i+r][c+j]] ) return false;
                distinct[grid[i+r][c+j]] = true;
            }
        }
        // row checking...
        for(int i=0;i<3;i++){
            int sum  = 0;
            for(int j=0;j<3;j++){
                sum += grid[r+i][c+j];
            }
            if(value == -1) value = sum;
            else if(value != sum) return false;
        }
        // Column checking...
        for(int i=0;i<3;i++){
            int sum  = 0;
            for(int j=0;j<3;j++){
                sum += grid[r+j][c+i];
            }
            if(sum != value) return false;
        }
        // diagonal checking...
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] != value) return false;
        if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c] != value) return false;
        return true;
    }

}