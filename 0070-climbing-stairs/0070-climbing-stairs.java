class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return f_cs(dp , n);
    }
    public int f_cs(int[] dp , int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = f_cs(dp , n-1) + f_cs(dp , n-2);
    }
}