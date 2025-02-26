class Solution {
    public int[][] matrixReshape(int[][] matrix, int r, int c) {
         int row = matrix.length;
         int col = matrix[0].length;
         if(row *col !=  r*c) return matrix;
         row = 0;
         col  = 0;
         int[][] res = new int[r][c];
         for(int i = 0;i < r;i++){
            for(int j  = 0;j < c;j++){
                res[i][j] = matrix[row][col++];
                if(col == matrix[0].length){
                    col = 0;
                    row++;
                }
            }
         }
         return res;
    }
}