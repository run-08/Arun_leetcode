class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length, res = 0;
        if(n < d) return -1;
        int[][] dp = new int[n][d+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return memo(0,dp,n,jobDifficulty,d);
    }
    private int memo(int i,int[][] dp,int n,int[] job, int d){
        if (i == n && d == 0) return 0;
        if (i == n || d == 0) return 1000000;
        if(dp[i][d]!=-1) return dp[i][d];
        int max=0,res = 1000000;
        for(int k=i;k<=n-d;k++){
           max = Math.max(job[k],max);
           res = Math.min(res,max+memo(k+1,dp,n,job,d-1));
        }
        return dp[i][d]=res;
    }
}