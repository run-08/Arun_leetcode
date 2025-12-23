class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        dp = new int[n][k+1];
        Arrays
              .sort(events,(a,b) -> a[0]-b[0]);
        IntStream
              .range(0,n)
              .forEach(idx -> Arrays.fill(dp[idx],-1));
        return helper(0,events,n,k);
    }
    private int helper(int idx,int[][] events,int n,int k){
        if(idx==n|| k <= 0) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];
        int low=idx+1,high=n,end=events[idx][1];
        while(low < high){
            int mid = low + (high-low)/2;
            if(events[mid][0] > end) high=mid;
            else low = mid+1;
        }
        return dp[idx][k] = Math.max(
            // skip....
            helper(idx+1,events,n,k),
            // include
            events[idx][2] + ((low < n && events[low][0]>end)?helper(low,events,n,k-1):0)
        );
    }
}