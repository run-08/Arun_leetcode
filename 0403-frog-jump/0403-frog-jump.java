class Solution {
    
    HashMap < Integer, Integer > map;
    HashMap < Integer, HashMap < Integer, Boolean > > memo;
    int noOfStones;
    int [] nums;

    public boolean canCross(int[] stones) {

         this.noOfStones = stones.length;
         this.nums = stones;
         this.memo = new HashMap <>(); this.map = new HashMap <> ();

         if ( noOfStones >= 2 && stones [ 1 ] != stones [ 0 ] + 1  ) return false;

         for ( int index = 1 ; index < noOfStones ; index++ ) {

            map.put( stones [ index ], index );
            memo.put ( index, new HashMap <> () );

         }

         boolean ans = dfs ( 1, 1 );

         return ans;

    }

    private boolean dfs ( int index, int steps ) {

        if ( index == noOfStones - 1 ) return true;

        if ( memo.get ( index ).containsKey ( steps ) ) return memo.get ( index ).get ( steps ); 

        boolean isReach = false;

        for ( int step = steps - 1 ; step < steps + 2 ; step++ ) if ( step != 0 && map.containsKey ( step + nums [ index ] ) ) isReach = isReach || dfs( map.get ( step + nums [ index ] ), step );

        memo.get( index ).put ( steps, isReach );

        return memo.get ( index ).get ( steps ); 

    }
}