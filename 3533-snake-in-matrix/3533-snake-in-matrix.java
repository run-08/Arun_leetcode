class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;
        int[][] arr = new int[n][n];
        int value = 0;
        for(int i = 0;i < n;i++) for(int j = 0;j < n;j++) arr[i][j] = value++;
        for(String val : commands){
            if(val.equals("UP")) row--;
            else if(val.equals("DOWN")) row++;
            else if(val.equals("RIGHT")) col++;
            else col--;
        }
        return arr[row][col];
    }
}