class Solution {

    public boolean checkValid(int[][] arr ) {

        int n = arr.length;
        HashSet < Integer > set = new HashSet <> ();

        for ( int index = 1 ; index <= n ; index++ ) set.add( index  );
        
         for ( int index = 0 ; index < n ; index++ ) {

            HashSet < Integer > tempSet = new HashSet <> ( set );

            for ( int index1 = 0 ; index1 < n ; index1++ ) if( !tempSet.remove ( arr [ index ] [ index1 ] ) ) return false;

            if ( tempSet.size () != 0 ) return false;

         }
        
        for ( int index = 0 ; index < n ; index++ ) {

            HashSet < Integer > tempSet = new HashSet <> ( set );

            for ( int index1 = 0 ; index1 < n ; index1++ ) if( !tempSet.remove ( arr [ index1 ] [ index ] ) ) return false;

            if ( tempSet.size () != 0 ) return false;

        }

        return true;

    }
}