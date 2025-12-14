class Solution {
    Boolean[][] dp;
    Boolean[][] isPalindrome;
    public boolean checkPartitioning(String s) {
        int n = s.length();
        dp = new Boolean[n][4];
        isPalindrome = new Boolean[n+1][n+1];
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                isPalindrome(s,i,j);
            }
        }
        // System.out.print(Arrays.deepToString(isPalindrome));
        return helper(s,0,3,n);
    }
    private boolean helper(String s,int idx,int k,int n){
        if(k<0 || n-idx < k || idx>n) return false;
        if(idx==n&&k==0) return true;
        if(dp[idx][k] != null) return dp[idx][k];
        boolean flag = false;
        for(int i=idx;i<n;i++){
            if(isPalindrome[idx][i] != null && isPalindrome[idx][i]){
                if(helper(s,i+1,k-1,n)) {
                  return dp[idx][k]=true;
                }
            }
        }
        return dp[idx][k]=false;
    }

    private boolean isPalindrome(String s, int i, int j){
        if(i>=j) return isPalindrome[i][j]=true;
        if(isPalindrome[i][j] != null) return true;
        if(s.charAt(i) != s.charAt(j)) return isPalindrome[i][j]=false;
        return isPalindrome[i][j] = isPalindrome(s,i+1,j-1);
    }
}