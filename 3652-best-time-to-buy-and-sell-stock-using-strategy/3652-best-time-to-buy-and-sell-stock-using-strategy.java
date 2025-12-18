class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long max=Long.MIN_VALUE;
        long[] strategy_preSum = new long[n],preSum = new long[n];
        preSum[0]=prices[0];
        strategy_preSum[0] = prices[0]*strategy[0];
        for(int i=1;i<n;i++) {
            strategy_preSum[i] = strategy_preSum[i-1]+(prices[i]*strategy[i]);
            preSum[i]=preSum[i-1]+prices[i];
        }
        max = strategy_preSum[n-1];
       for (int i = 0; i + k <= n; i++) {
            long leftHalf = (i > 0) ? strategy_preSum[i-1] : 0;
            long rightHalf = (i + k < n) ? strategy_preSum[n-1] - strategy_preSum[i+k-1] : 0;
            int sellStart = i + k/2;
            int sellEnd   = i + k - 1;
            long rightKhalf;
            if (sellStart == 0)rightKhalf = preSum[sellEnd];
            else rightKhalf = preSum[sellEnd] - preSum[sellStart - 1];
            max = Math.max(max, leftHalf + rightHalf + rightKhalf);
        }
        return max; 
    } 
}