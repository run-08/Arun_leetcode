class Solution {
    public void setZeroes(int[][] matrix) {
       boolean  isRow = false;
       boolean  isColumn = false;
        for(int i = 0;i < matrix.length;i++){
            if(matrix[i][0] == 0) isRow = true;
            if(isRow) break;
        }
        for(int i = 0;i < matrix[0].length;i++){
            if(matrix[0][i] == 0) isColumn = true;
            if(isColumn) break;
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i <  matrix[0].length;i++){
            if(matrix[0][i] != 0) continue;
            for(int j = 0;j < matrix.length;j++) matrix[j][i] = 0;
        }
        for(int i = 1;i < matrix.length;i++){
            if(matrix[i][0] != 0)continue;
            for(int j = 0;j < matrix[0].length;j++) matrix[i][j] = 0;
        }
        
        if(isRow) row(matrix);
        if(isColumn) column(matrix);
    }
    public void row(int[][] matrix){
           for(int i = 0;i < matrix.length;i++) matrix[i][0] = 0;
    }
    public void column(int[][] matrix){
          for(int j = 0;j < matrix[0].length;j++) matrix[0][j] = 0;
    }
}