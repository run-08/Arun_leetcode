class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length , res = 0 , m = grid[0].length;
        int[] arr = new int[m*n];
        int idx = 0;
        for(int[] row : grid) for(int val : row) arr[idx++] = val;
        Arrays.sort(arr);
        int mid_value = arr[arr.length / 2 ];
        for(int val : arr ){
           int complement = Math.abs(mid_value-val);
           if(complement % x != 0) return -1;
           res += complement / x;
        }
        return res;
    }
}