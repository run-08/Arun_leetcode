class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < matrix.length;i++){
            int min = Integer.MAX_VALUE;
            int pos = 0;
            for(int j = 0;j < matrix[0].length;j++){
                 if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    pos = j;
                 }
            }
            System.out.print(pos);
            int max = Integer.MIN_VALUE;
            for(int j = 0;j < matrix.length;j++)   if(matrix[j][pos] > max) max =  matrix[j][pos];          
            if(max == min) res.add(max);
        }
        return res;
    }
}