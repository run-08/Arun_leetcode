class Solution {

    int [] [] dp;
    int numsLength, target;
    int [] nums;

    public int maximumJumps(int[] nums, int target) {
        
        numsLength = nums.length;
        this.nums = nums; this.target = target;
        dp = new int [ numsLength ] [ numsLength ];

        for ( int index = 0 ; index < numsLength ; index++ ) Arrays.fill(  dp [ index ], -1 );

        int ans = dfs ( 1, 0 );

        // for ( int index = 0 ; index < numsLength ; index++ ) System.out.print( Arrays.toString ( dp [ index ]   ) + "\n" );
        

        return ans < 0 ? -1 : ans;

    }

    private int dfs ( int index, int previousIndex ) {

        if ( previousIndex == numsLength - 1 ) return 0;

        if (index >= numsLength) return Integer.MIN_VALUE / 2;

        if ( dp [ index ] [ previousIndex ] != -1 ) return dp [ index ] [ previousIndex ];

       int taken = ( Math.abs ( nums [ index ] - nums [ previousIndex ] ) <= target ) ?  dfs ( index + 1, index ) : Integer.MIN_VALUE / 2 ;
       
       int not_taken = dfs ( index + 1, previousIndex );

       if ( taken != Integer.MIN_VALUE / 2 ) taken += 1;

        return dp [ index ] [ previousIndex ] = Math.max ( taken, not_taken );

    }
}