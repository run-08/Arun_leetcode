class Solution {
    int[][] dp;
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays
            .sort(events,(a,b)->a[0]-b[0]);
        dp = new int[n][2];
        IntStream
           .range(0,n)
           .forEach( i -> Arrays.fill(dp[i],-1));
            return helper(events,0,0,n);
    }
    private int helper(int[][] events,int idx,int count,int n){
        if(count==2 || idx==n) return 0;
        if(dp[idx][count] != -1) return dp[idx][count];
        int nextIndex = idx+1,endIndex = n;
        while(nextIndex < endIndex){
            int mid = nextIndex + ( endIndex - nextIndex ) / 2;
            if(events[mid][0] > events[idx][1] ) endIndex = mid;
            else nextIndex = mid + 1;
        }
        return dp[idx][count] = Math.max(
            // skip....
            helper(events,idx+1,count,n),
            // include
            events[idx][2]+((nextIndex < n && events[nextIndex][0] > events[idx][1]) ? helper(events,nextIndex,count+1,n) : 0)
        );
    }

}