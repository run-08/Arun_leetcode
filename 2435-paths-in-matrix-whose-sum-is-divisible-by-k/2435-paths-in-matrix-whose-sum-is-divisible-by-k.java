class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length,m=grid[0].length;
        int[][][] dp = new int[n][m][k];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) Arrays.fill(dp[i][j],-1);
        return dfs(grid,dp,m,n,0,0,0,k);
    }
    private int dfs(int[][] grid,int[][][] dp,int m,int n,int r,int c,int sum, int k){
        sum = (sum + grid[r][c]) % k;
        if(r >= n || c >= m) return 0;
        if(r==n-1&&c==m-1) return sum == 0 ? 1 : 0;
        if(dp[r][c][sum] != -1) return dp[r][c][sum%k];
        long count=0;
        int[][] dir = {{0,1},{1,0}};
        for(int[] d:dir) if(d[0]+r<n&&d[1]+c < m) count += dfs(grid,dp,m,n,r+d[0],c+d[1],sum,k);
        return dp[r][c][sum%k] = (int)(count % (1000000007)); 
    }
}