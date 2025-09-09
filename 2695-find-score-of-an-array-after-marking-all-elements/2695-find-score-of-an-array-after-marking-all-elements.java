class Solution {

    public long findScore(int[] nums) {
        
        HashMap < Integer, Queue < int [] > > map = new HashMap <> ();
        PriorityQueue < Integer > minHeap = new PriorityQueue <> ();
        int numsLength = nums.length;
        HashSet < Integer > marked = new HashSet <> ();
        long score = 0;

        for ( int index = 0 ; index < numsLength ; index++ ) {
            
            map.put( nums [ index ], new ArrayDeque <> () );
            marked.add ( nums [ index ] );

        }

        for ( int val : marked ) minHeap.add ( val );
        marked = new HashSet <> ();

        for ( int index = 0 ; index < numsLength ; index++ ) {
    
                if ( index == 0 ) map.get( nums [ index ] ).add ( new int [] { index, index + 1 } );
                else if ( index == numsLength - 1 ) map.get ( nums [ index ] ).add ( new int [] { index, index - 1 } );
                else map.get ( nums [ index ] ).add ( new int [] { index, index - 1, index + 1 } );

        }

       

        while ( !minHeap.isEmpty () ) {
     
            
            int small = minHeap.peek() ;
            int [] cell = map.get ( small ).poll();
            if ( map.get ( small ).isEmpty() ) minHeap.poll();

            if ( marked.contains ( cell [ 0 ] ) ) continue;
            for ( int markingIndex : cell ) marked.add ( markingIndex );
            score += small;

        }

        return score;

    }
}