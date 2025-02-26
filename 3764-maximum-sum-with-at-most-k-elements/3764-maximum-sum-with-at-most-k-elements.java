class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long sum = 0;
        List<Integer> ls = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n;i++){
            Arrays.sort(grid[i]);
            int range = limits[i];
            int col = m-1;
            for(int j = col;range != 0;j--){
                 ls.add(grid[i][j]);
                 range--;
            }
        }
        int size = ls.size();
        Collections.sort(ls);
        while(k!= 0) {
            sum += ls.get(--size);
            k--;
        } 
        return sum;
    }
}