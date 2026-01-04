class Solution {
    int[][][] dp;
    private final int MOD = 1_000_000_007;
    public int numOfArrays(int n, int m, int k) {
        dp = new int[n+1][k+1][m+1];
        for(int i=0;i<=n;i++) for(int j=0;j<=k;j++) Arrays.fill(dp[i][j],-1);
        return helper(0,n,0,k,0,m) % MOD;
    }
    private int helper(int prev,int n, int changes,int k, int idx,int m){
        if(idx == n) return k == changes ? 1 : 0;
        if(changes > k) return 0;
        if(dp[idx][changes][prev] != -1) return dp[idx][changes][prev];
        long count = 0;
        // mines....
        // Try out all possibilities...
        // for(int i=1;i<=m;i++) {
        //     int max = Math.max(i,prev);
        //     count = ( count + helper(max,n,(max>prev?1+changes:changes),k,idx+1,m) ) % MOD;
        // }
        // solutions...
        // We need to consider only maximum, so just pickup the prev + 1 and prev - 1 and prev as possible...
        // so only 3 states...
        // Let us took prev - 1;
        // possible ways... Assume if changes == k, then we only need to consider lowest as possible to length become = n... so we multiply....
        if (prev > 0) {
            count += (long) prev *
                     helper(prev, n, changes, k, idx + 1, m);
        }
        // Go for maximum....
        for (int newMax = prev + 1; newMax <= m; newMax++) {
            count += helper(newMax, n, changes + 1, k, idx + 1, m);
        }
        return dp[idx][changes][prev] = (int)(count % MOD);
    }
}