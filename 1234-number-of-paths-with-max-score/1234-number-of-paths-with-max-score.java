class Solution {

    int [] [] dp;
    int size;
    int [] [] arr;
    int [] [] directions;
    int maxPath;
    int [] [] countDP;
    public final int MOD = 1000000007;

    public int[] pathsWithMaxScore( List<String> board) {
        
        this.size = board.get ( 0 ).length();
        dp = new int [ size ] [ size ];
        arr = new int [ size ] [ size ];
        maxPath = 0;
        this.countDP = new int [ size ] [ size ]; 

        int [] [] dir = {
            { 0 , -1 },
            { -1 , -1 },
            { -1 , 0 }
        };

        this.directions = dir;

        for ( int index = 0 ; index < size ; index++ ) {

             String word = board.get ( index );
             
             for ( int index1 = 0 ; index1 < size ; index1++ ) this.arr [ index ] [ index1 ] = ( word.charAt ( index1 ) >= '1' && word.charAt ( index1 ) <= '9' ) ? word.charAt ( index1 ) - '0' : -1;
  
        }

        arr [ 0 ] [ 0 ] = -3;
        arr [ size - 1 ] [ size - 1 ] = 0;

        // System.out.print( Arrays.deepToString ( arr ) );

        for ( int index = 0 ; index < size; index++ ) Arrays.fill( dp [ index ], -1 );
        
        long [] ans = dfs( size - 1, size -1 );

        if ( ans [ 1 ] == 0 ) return new int [] { 0, 0 };

        return new int [] { (int)ans [ 0 ] , (int)ans [ 1 ] };
        
    }

    private long [] dfs ( int row, int col ) {

        if ( row < 0 || col < 0 || row >= size || col >= size || arr [ row ] [ col ] == -1 ) return new long [] { -1, 0 };
        if ( dp [ row ] [ col ] != -1 ) return new long [] { dp [ row ] [ col ], countDP [ row ] [ col ] };

        if ( arr [ row ] [ col ] == -3 ) return new long [] { 0, 1 };

        long maxSum = -1 , maxPath = 0;

        for ( int []  dir : directions ) {
            
            long optimalPath [] = dfs ( row + dir [ 0 ], col + dir [ 1 ] );

            if ( maxSum  < optimalPath [ 0 ] + arr [ row ] [ col ] ) {

                 maxPath = optimalPath [ 1 ] % MOD;
                 maxSum = ( optimalPath [ 0 ] + arr [ row ] [ col ]  );

            }

            else if ( maxSum == optimalPath [ 0 ] + arr [ row ] [ col ] ) maxPath = ( maxPath + optimalPath [ 1 ] ) % MOD;

        }

        dp [ row ] [ col ] = (int)( maxSum ) ;
        countDP [ row ] [ col ] = (int)maxPath;

        return new long [] { dp [ row ] [ col ], countDP [ row ] [ col ] };


    }
}