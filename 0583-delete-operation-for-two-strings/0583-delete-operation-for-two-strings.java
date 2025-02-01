class Solution {
    public int minDistance(String word1, String word2) {
         int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row+1][col+1];
        for(int i = 1;i < row+1;i++){
            for(int j  = 1;j < col+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return row-dp[row][col]+col-dp[row][col];
    }
}