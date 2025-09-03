class Solution {

    int [] [] [] dp ;
    int m, n, maxMoves;
    private final int MOD = 1000000007;
    int [] [] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
            this.dp = new int [ m ] [ n ] [ maxMove ];
            this.m = m;
            this.n = n;
            this.maxMoves = maxMove;

            for ( int index = 0 ; index < m ; index++ ) for ( int index1 = 0 ; index1 < n ; index1++ ) Arrays.fill( dp [ index ] [ index1 ], -1 );

            return dfs( startRow, startColumn, 0 );

    }

    private int dfs ( int index, int index1, int moves ) {

        if ( index == m || index1 == n || index < 0 || index1 < 0 ) return 1;

        if ( moves == maxMoves ) return 0;

        if ( dp [ index ] [ index1 ] [ moves ] != -1 ) return dp [ index ] [ index1 ] [ moves ];

        long sum = 0;

        for ( int dir [] : directions ) sum = ( sum + dfs( index + dir [ 0 ], index1 + dir [ 1 ], moves + 1 ) ) % MOD;

        return dp [ index ] [ index1 ] [ moves ] = ( int )sum;

    }
}