class Solution {
    Boolean[][] isPal;
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        isPal = new Boolean[n][n];
        dp = new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++) for(int j=i;j<n;j++) isPal[i][j]=check(s,i,j);
        return helper(s,0,n)-1;
    }
    private int helper(String s,int idx, int n){
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int min = 2001;
        for(int i=idx;i<n;i++) if(isPal[idx][i]) min=Math.min(min,1+helper(s,i+1,n));
        return dp[idx]=min;
    }
    private boolean check(String s, int i, int j){
        if(i>=j) return true;
        if(isPal[i][j] != null) return isPal[i][j];
        if(s.charAt(i)!=s.charAt(j)) return isPal[i][j] = false;
        return isPal[i][j] = check(s,i+1,j-1);
    }
}