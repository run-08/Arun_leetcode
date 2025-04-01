class Solution {
    long max;
    public long mostPoints(int[][] questions) {
         int n = questions.length;
         if(n == 1) return questions[0][0];
         max = 0;
         long[] dp = new long[n];
         dp[n-1] = questions[n-1][0];
         for(int i = n-2; i >=0 ;i--) {
            dp[i] += questions[i][0];
            if(i+questions[i][1] < n-1) dp[i] += dp[(i+questions[i][1])+1];
            dp[i] = Math.max(dp[i] , dp[i+1]);
            max = Math.max(dp[i] , max);
         }
         return max;
    }
}