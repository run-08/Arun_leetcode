class Solution {

    int [] [] [] dp ; int [] []  nums;
    int m , n;
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        this.m = m;this.n = n;
        int strsSize = strs.length;
        dp = new int [ strsSize ] [ m + 1 ] [ n + 1 ];
        nums = new int [ strsSize ] [ 2 ];

        for ( int index = 0 ; index < strsSize ; index++ ) {

            String str = strs [ index ];
            int strLength = str.length() , ones = 0;

            for ( int index1 = 0 ; index1 < strLength ; index1++ ) if ( str.charAt ( index1 ) == '1' ) ones++;

            nums [ index ] [ 0 ] = strLength - ones;
            nums [ index ] [ 1 ] = ones;

        }

        for ( int index = 0 ; index < strsSize ; index++ ) for ( int index1 = 0 ; index1 < m + 1 ; index1++ ) Arrays.fill( dp [ index ] [ index1 ] , -1 );

    
        return  MaxOnesAndZeros ( strsSize - 1  , 0 , 0 );

    }

    private int MaxOnesAndZeros ( int index , int M , int N ) {

        if ( M > m || N > n ) return Integer.MIN_VALUE;
        if ( index < 0 ) return 0;
        if ( dp [ index ] [ M ] [ N ] != -1  ) return dp [ index ] [ M ] [ N ];

        int taken = MaxOnesAndZeros ( index - 1 , M + nums [ index ] [ 0 ] , N + nums [ index ] [ 1 ] )   , notTaken = MaxOnesAndZeros ( index - 1 , M , N );

        taken = ( taken != Integer.MIN_VALUE ) ? taken + 1 : taken; 

        return dp [ index ] [ M ] [ N ] = Math.max ( taken , notTaken );
        
    }
}