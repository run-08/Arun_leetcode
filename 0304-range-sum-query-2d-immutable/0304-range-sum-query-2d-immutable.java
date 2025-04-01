class NumMatrix {
    int row , col;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        row = matrix.length ; col = matrix[0].length;
        for(int i = 0;i < row;i++) {
            int sum = 0;
            for(int j = 0;j < col;j++) {
                sum += matrix[i][j];
                matrix[i][j] = sum;
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i <= row2;i++) {
            sum += matrix[i][col2];
            if(col1-1 >= 0) sum -= matrix[i][col1-1];
        }
        return sum;
    }
}
