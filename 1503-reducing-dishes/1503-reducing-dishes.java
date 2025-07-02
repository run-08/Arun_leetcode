class Solution {
    private static int size;
    public int maxSatisfaction(int[] dishes) {
        size = dishes.length;
        Arrays.sort(dishes);
        int[][] dp = new int[size+1][size+1];
        for( int i = 0;i < size;i++) Arrays.fill( dp[i] , -1);
        return countMaxSatisfication(dishes , 0 , 1 , dp);
        
    }

    private static int countMaxSatisfication(int[] dishes , int idx , int time , int[][] dp){
        if( idx == size || time == size+1 ) {
            return 0;
        }
        if(dp[idx][time] != -1) return  dp[idx][time];
        // take the dishes
        int include = ( dishes[idx]*time )+countMaxSatisfication(dishes, idx+1 , time+1,  dp);
        int exclude = countMaxSatisfication(dishes, idx+1, time , dp);
         
        return dp[idx][time] = Math.max( include , exclude);
    }
}