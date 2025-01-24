class Solution {
    static public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return coinchangetwo(coins , amount , coins.length-1 , dp);
    }
    static public int coinchangetwo(int[] arr , int amt , int idx, Integer[][] dp){
        if(amt == 0) return 1;
        if(idx < 0 || amt < 0) return 0;
        if(dp[idx][amt] != null) return dp[idx][amt];
        int exclude = coinchangetwo(arr , amt ,  idx -1 , dp);
        int include = ((amt >= arr[idx]) ? coinchangetwo(arr , amt-arr[idx] , idx , dp) : 0);
         dp[idx][amt] = include+exclude;
        return dp[idx][amt];
    }
}