class Solution {
    int[] arr;
    public int maxSumAfterPartitioning(int[] arr, int k) {
              this.arr = arr;
              int n = arr.length;
              Integer[] dp = new Integer[n];
              return (findMaximumParition( n-1 , k , dp));
    }
    private int findMaximumParition( int ind , int k , Integer[] dp ){
            if(ind < 0) return 0;
            if( dp[ind] != null) return dp[ind];
            int maxEle = 0 ,  curSum = 0;
            for( int i = ind;i >= 0 && (ind - i)+1 <= k;i--){
                curSum = Math.max( curSum , arr[i]);
                maxEle = Math.max(maxEle , curSum*(ind-i+1)+findMaximumParition(i-1, k , dp) );
            }
            return dp[ind] = maxEle;  
    }
}