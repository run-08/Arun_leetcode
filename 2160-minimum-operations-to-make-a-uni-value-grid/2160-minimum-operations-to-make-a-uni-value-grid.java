class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length , res = 0;
        List<Integer> ls = new ArrayList<>();
        for(int[] row : grid) {
            for(int val : row) ls.add(val);
        }
        Collections.sort(ls);
        // System.out.print(ls);
        int mid_value = ls.get( ls.size() / 2 );
        for(int val : ls ){
           int complement = Math.abs(mid_value-val);
           if(complement % x != 0) return -1;
           res += complement / x;
        }
        return res;
    }
}