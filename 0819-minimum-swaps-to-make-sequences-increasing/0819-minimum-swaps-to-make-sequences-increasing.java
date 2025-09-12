class Solution {

    int [] [] dp;
    int numsSize ;
    public int minSwap(int[] nums1, int[] nums2) {
        
        this.numsSize = nums1.length;
        this.dp  = new int [ numsSize ] [ 2 ];

       for ( int index = 0 ; index < numsSize ; index++ ) Arrays.fill( dp [ index ], -1 );
        
       return Math.min ( dfs ( nums1, nums2, 1, 0 ), 1 + dfs ( nums1, nums2, 1, 1 ) );
          
    }

    private int dfs ( int [] nums1, int [] nums2, int index, int swapIndex  ) {

        if ( index == numsSize ) return 0;

        if ( dp [ index ] [ swapIndex ] != -1 ) return dp [ index ] [ swapIndex ];

        int prev1 =  nums1 [ index - 1 ], prev2 = nums2 [ index - 1 ], swapped = Integer.MAX_VALUE, non_swapped = Integer.MAX_VALUE;

        if ( swapIndex == 1 ) {

            prev1 = nums2 [ index - 1 ];
            prev2 = nums1 [ index - 1 ];

        }

        // non-swapping 
        
       if ( nums1 [ index ] > prev1 && nums2 [ index ] > prev2 ) non_swapped = dfs ( nums1, nums2, index + 1, 0 );

    //    swapping

       if ( nums1 [ index ] > prev2 && nums2 [ index ] > prev1 ) swapped = 1 +  dfs ( nums1, nums2, index + 1, 1 );
       
        
       return dp [ index ] [ swapIndex ] = Math.min ( non_swapped, swapped );

    }
}