class Solution {

    int [][] dp;
    int n;

    public int integerBreak(int n) {
        
           this.dp = new int [ n ] [ n ];
           this.n = n;
           for ( int index = 0 ; index < n ; index++ ) Arrays.fill ( dp [ index ], -1 );

           int ans = memoization ( 1, 0 );

           return ans;

    }

    private int memoization ( int index, int sum ) {

         if ( sum == n ) return 1;

          if ( sum > n || index >= n ) return 0;

         if ( dp [ index ] [ sum ] != -1 ) return dp  [ index ] [ sum ];

         int taken = index * memoization ( index, sum + index ), not_taken = memoization ( index + 1, sum );

         return dp [ index ] [ sum ] = Math.max ( taken, not_taken );

    }
}