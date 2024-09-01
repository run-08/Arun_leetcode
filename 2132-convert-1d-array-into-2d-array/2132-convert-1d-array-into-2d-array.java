class Solution {
    public int[][] construct2DArray(int[] o, int m, int n) {
        if(o.length  > m*n || o.length < m*n) return new int[0][0];
        int idx = 0;
        int res[][] = new int[m][n];
        for(int i = 0;i < m && idx < o.length;i++){
            for(int j = 0;j < n && idx < o.length;j++) res[i][j] = o[idx++];
        }
        return res;
    }
}