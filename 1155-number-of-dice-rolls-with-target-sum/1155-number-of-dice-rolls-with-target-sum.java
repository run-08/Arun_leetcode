class Solution {
    int[][] dp;
    private static final int MOD = 1_000_000_007; 
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,k,0,target) % MOD;
    }
    private int helper(int n,int k,int sum,int target){
        if(sum == target && n == -1) return 1;
        if(n == -1 || sum >= target) return 0;
        if(dp[n][sum] != -1) return dp[n][sum];
        long cnt = 0;
        for(int i=1;i<=k;i++) {
            cnt = (cnt + helper(n-1,k,sum+i,target)) % MOD;
        }
        return dp[n][sum] = (int)cnt;
    }
}