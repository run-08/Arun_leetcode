class Solution {


    HashMap < Integer, HashMap < Integer, Integer > > memo;

    public int makeArrayIncreasing ( int [] arr, int [] arr1 ) {

        Arrays.sort( arr1 );

        memo = new HashMap<>();

        for ( int index = 0 ; index < arr.length ; index++ ) memo.put( index, new HashMap <> () );

        int ans = dfs( 0, -1, arr, arr1 );

        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;

    }

    private int dfs ( int index, int prev, int [] arr, int [] arr1 )  {

        if ( index == arr.length ) return 0;

        if ( memo.get ( index ).containsKey ( prev + 1 ) ) return memo.get( index ).get( prev + 1 );

        int not_change = Integer.MAX_VALUE / 2, change = Integer.MAX_VALUE / 2;

        if ( arr [ index ] > prev ) not_change = dfs( index + 1, arr [ index ], arr, arr1 );

        int searchIdx = search( arr1, prev + 1 );

        if ( searchIdx != -1 ) change = 1 + dfs( index + 1, arr1 [ searchIdx ], arr, arr1 );

        memo.get ( index ).put ( prev + 1, Math.min( not_change, change ) );

        return memo.get( index ).get( prev + 1 );
    }

    private int search ( int [] arr1, int target ) {

        int s = 0, e = arr1.length - 1, ans = -1;

        while ( s <= e ) {

            int m = s + ( e - s ) / 2;

            if ( arr1 [ m ] >= target ) {
                ans = m;
                e = m - 1;
            }
            else s = m + 1;

        }

        return ans;

    }
}
