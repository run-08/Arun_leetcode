class Solution {
    public int minDistance(String w1, String w2) {
        int row = w1.length()  , col = w2.length();
        Integer[][] dp = new Integer[row][col];
        return fun(w1 , w2 , dp , row-1 , col-1);
    }
        private int fun(String w1 , String w2 , Integer[][] dp , int idx1 , int idx2){
         if(idx2 < 0) return idx1+1;
         if(idx1 < 0) return idx2+1;
         if(dp[idx1][idx2] != null) return dp[idx1][idx2];
         if(w1.charAt(idx1) == w2.charAt(idx2)) {
            dp[idx1][idx2] = fun(w1 , w2 , dp , idx1-1 , idx2-1);
            return dp[idx1][idx2];
         }  
         else {
            // Insert
             int I = 1 + fun(w1  , w2 , dp , idx1 , idx2-1);
            //  Delete
             int D = 1 + fun(w1 , w2 , dp ,  idx1-1 , idx2);
            //  Update
             int R = 1 + fun(w1 , w2 , dp , idx1-1 , idx2-1);
             return dp[idx1][idx2] = Math.min(I , Math.min(D , R));
         }
    }
}