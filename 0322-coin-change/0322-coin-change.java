class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount  == 0) return 0;
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        fun(coins , n-1 , dp ,  amount) ;
        return dp[n-1][amount] != Integer.MAX_VALUE ? dp[n-1][amount] : -1;
    }
    private int fun( int[] arr , int idx , Integer[][] dp , int amount  ){
          if(amount == 0) return 0;
          if(amount < 0 || idx < 0) return Integer.MAX_VALUE;
          if(dp[idx][amount] != null) return dp[idx][amount];
          int not_taken = fun(arr , idx-1 , dp , amount);
          int res = fun(arr , idx , dp , amount-arr[idx]);
          int taken  = (res != Integer.MAX_VALUE) ? 1+res : res;
         return dp[idx][amount]= Math.min( taken ,  not_taken);
    } 
}