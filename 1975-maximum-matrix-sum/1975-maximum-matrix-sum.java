class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long negativeCount = 0, sum = 0, minValue = Integer.MAX_VALUE / 2,n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int value = matrix[i][j];
                minValue = Math.min(minValue, Math.abs(value));
                if(value < 0)  negativeCount++;
                sum += Math.abs(value);
            }
        }
        if(negativeCount % 2 != 0) sum -= 2*(minValue);
        return sum;
    }
}