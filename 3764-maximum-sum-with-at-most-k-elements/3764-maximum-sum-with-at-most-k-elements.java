class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n;i++){
            Arrays.sort(grid[i]);
            int range = limits[i];
            int col = m-1;
            for(int j = col;range != 0;j--){
                 pq.offer(grid[i][j]);
                 range--;
            }
        }
        int size = pq.size();
        while(!pq.isEmpty()) {
            int ele = pq.poll();
            if(size <= k) sum += ele;
            size--;
        } 
        return sum;
    }
}