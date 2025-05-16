class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);
        return memo_f_robber(nums , dp , n-1);
    }
//  private static int rec_f_robber(int[] arr , int idx){
//     if(idx < 0) return 0;
//     if(idx == 0) return arr[0];
//    return Math.max( (arr[idx]+rec_f_robber(arr , idx-2)) , (rec_f_robber(arr , idx-1)) );
// }
private static int memo_f_robber(int[] arr , int[] dp , int idx){
    if(idx < 0) return 0;
    if(idx == 0) return arr[0];
    if(dp[idx] != -1) return dp[idx];
    return dp[idx] = Math.max( arr[idx]+memo_f_robber(arr, dp , idx-2) , (memo_f_robber(arr,dp , idx-1)) );
  }
}