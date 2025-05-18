class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[] dp = new Integer[n];
        return fun(days , dp , n-1 , costs);
    }
    private  int fun(int[] days , Integer[] dp , int idx , int[] cost){
            if(idx < 0 ) return 0;
            if(dp[idx] != null) return dp[idx];
            int day = cost[0]+fun(days , dp ,  idx-1 , cost);
            int i = idx;
            while(i >= 0 && days[i] > days[idx]-7) {
                i--;
            }
            int week = cost[1]+fun(days , dp ,i , cost);
            i = idx;
            while(i >= 0 && days[i] > days[idx]-30) {
                i--;
            }
            int month = cost[2]+fun(days , dp , i , cost);
            return dp[idx] = Math.min(day , Math.min(week , month)); 
    }
}