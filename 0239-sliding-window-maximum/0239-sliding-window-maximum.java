class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // int numsLength = nums.length , maxIndex  = 0 , idx = 0;
        // int [] maximumSlidedWindow = new int [ numsLength - k + 1 ];

        // for ( int index = 1 ; index < k ; index++ ) if ( nums [ index ] > nums [ maxIndex ] ) maxIndex = index;
        
        // maximumSlidedWindow [ idx++ ] = nums [ maxIndex ];
        
        // for ( int index = k ; index < numsLength ; index++ ) {

        //     if ( nums [ index ] >= nums [ maxIndex ] ) maxIndex = index;

        //     else if ( maxIndex <= index - k ) {
        
        //          int startPointer = index - k + 1 , endPointer = index ;

        //          maxIndex = startPointer;

        //          while ( startPointer <= endPointer ) {

        //               if ( nums [ startPointer ] > nums [ maxIndex ] ) maxIndex = startPointer;

        //               if ( nums [ endPointer ] > nums [ maxIndex ] ) maxIndex = endPointer;

        //               startPointer++;
        //               endPointer--;

        //          }

        //     }

        //     maximumSlidedWindow [ idx++ ] = nums [ maxIndex ];

        // }
     
        // return maximumSlidedWindow;
        

        //  TC : O ( N * K ) , but in practical -> TC : O ( N * ( K / 2 ) );
        // TLE at 50 / 51;

        int numsLength = nums.length , idx = 0;int [] maximumElementInSlidedWindow = new int [ numsLength - k + 1 ];
        Deque < Integer > dq = new ArrayDeque <> ();

        for ( int index = 0 ; index < numsLength ; index++ ) {

            if ( !dq.isEmpty() && dq.peekFirst() <= index - k  ) dq.pollFirst();

            while ( !dq.isEmpty() && nums [ index ] >= nums [ dq.peekLast() ] ) dq.pollLast();

            dq.addLast( index );

            if ( index >=  k - 1 ) maximumElementInSlidedWindow [ idx++ ] = nums [ dq.peekFirst() ];

        }

        return maximumElementInSlidedWindow;
        
    }
}