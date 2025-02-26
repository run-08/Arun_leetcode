class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] arr = new int[row][col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                int neighbour = 0;
                // Upper Row
                if(i-1 >= 0){
                    if(j-1 >= 0) if(board[i-1][j-1] == 1) neighbour++;
                    if(board[i-1][j] == 1) neighbour++;
                    if(j+1 < col) if(board[i-1][j+1] == 1) neighbour++;
                }
                // same row
                if(j-1 >= 0 ) if(board[i][j-1] == 1) neighbour++;
                if(j+1 < col)  if(board[i][j+1] == 1) neighbour++;
                // under row
                if(i+1 < row){
                   if(j-1 >= 0) if(board[i+1][j-1] == 1) neighbour++;
                   if(board[i+1][j] == 1) neighbour++;
                   if(j+1 < col) if(board[i+1][j+1] == 1) neighbour++;
                }
                if(board[i][j] == 0) {
                    if(neighbour == 3) arr[i][j] = 1;
                }
                else {
                    if(neighbour == 2 || neighbour == 3) arr[i][j] = 1;
                }
            }
        }
        for(int[] a : arr) System.out.print(Arrays.toString(a));
        for(int i = 0;i < row;i++) for(int j = 0;j < col;j++) board[i][j] = arr[i][j];
    }
}