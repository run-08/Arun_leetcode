class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i = 0;i < mat.length;i++){
            sum += mat[i][i];
            System.out.print(mat.length-i-1);
            if(mat.length-i-1 == i) continue;
            sum += mat[i][mat.length-i-1];
        }
        return sum;
    }
}