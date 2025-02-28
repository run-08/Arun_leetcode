class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int row = str1.length()+1;
        int col = str2.length()+1;
        int[][] dp = new int[row][col];
        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++){
                 if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                 else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        row--;
        col--;
        while(row > 0 && col > 0){
            if(str1.charAt(row-1) == str2.charAt(col-1)) {
                row--;
                col--;
                sb.append(str1.charAt(row));
            }
            else if(dp[row-1][col] > dp[row][col-1]){
                row--;
                sb.append(str1.charAt(row));
            }
            else {
                col--;
                sb.append(str2.charAt(col));
            }
        }
        while(row > 0){sb.append(str1.charAt(--row));}
        while(col > 0) {sb.append(str2.charAt(--col));}
        return sb.reverse().toString();
    }
}