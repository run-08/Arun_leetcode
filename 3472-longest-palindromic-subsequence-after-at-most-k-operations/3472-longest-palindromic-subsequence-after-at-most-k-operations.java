class Solution {
    int[][][] dp;
    public int longestPalindromicSubsequence(String s, int k) {
         int n = s.length();
         dp = new int[n][n][k+1];
         for(int i=0;i<n;i++) for(int j=0;j<n;j++) Arrays.fill(dp[i][j],-1);
         return helper(s,k,0,n-1);
    }
    private int helper(String s,int k,int idx1,int idx2){
        if(idx1 > idx2) return 0;
        if(idx1 == idx2) return 1;
        if(dp[idx1][idx2][k] != -1) return dp[idx1][idx2][k];
        int max = 0;
        if(s.charAt(idx1)==s.charAt(idx2)) max = 2+helper(s,k,idx1+1,idx2-1);
        else if(k!=0) {
            int diff = Math.abs(s.charAt(idx1) - s.charAt(idx2));
            int cost = Math.min(diff, 26 - diff);
            if(cost <= k) max = 2+helper(s,k-cost,idx1+1,idx2-1);
        }
        return dp[idx1][idx2][k]=Math.max (
             max,
             Math.max(helper(s,k,idx1+1,idx2),helper(s,k,idx1,idx2-1))
        );
    }
}