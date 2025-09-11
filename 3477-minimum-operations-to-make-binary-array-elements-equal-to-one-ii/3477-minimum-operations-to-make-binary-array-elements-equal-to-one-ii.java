class Solution {

    int numsLength;
    int dp [] [];
    public int minOperations(int[] nums) {

        this.numsLength = nums.length;
        this.dp = new int [ numsLength ] [ 2 ];

        for ( int index = 0 ; index < numsLength ; index++ ) { dp [ index ] [ 0 ] = -1; dp [ index ] [ 1 ] = -1; }
 
        return minflipToEqualsOne ( nums, false, 0 );

    }

    private int minflipToEqualsOne ( int [] arr, boolean isFlipped, int index ) {

        if ( index == numsLength ) return 0;

        int column =  isFlipped ? 0 : 1;
        
        if ( dp [ index ] [ column ] != -1 )  return dp [ index ] [ column ];  

        if ( isFlipped ) {
            
            if ( arr [ index ] == 0 ) return dp [ index ] [ 0 ] = minflipToEqualsOne ( arr, isFlipped, index + 1 );
            return dp [ index ] [ 0 ] = 1 + minflipToEqualsOne ( arr, !isFlipped, index + 1 );

        }

        if ( arr [ index ] == 1 ) return dp [ index ] [ 1 ] = minflipToEqualsOne ( arr, isFlipped, index + 1 );
        return dp [ index ] [ 1 ] = 1 + minflipToEqualsOne ( arr, !isFlipped, index + 1 );

    }
}