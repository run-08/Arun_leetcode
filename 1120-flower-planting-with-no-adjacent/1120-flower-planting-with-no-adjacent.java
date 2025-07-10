class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List < List < Integer > > edges = new ArrayList <> ();
        for ( int vertex = 0 ; vertex <= n ; vertex++ ) edges.add ( new ArrayList <> () );
        for ( int [] path : paths ) {
            edges.get ( path [ 0 ] ).add ( path [ 1 ] );
            edges.get ( path [ 1 ] ).add ( path [ 0 ] );
        }
        Queue < Integer > q = new ArrayDeque <> ();
        int [] coloredNodes = new int [ n  ];
        for ( int vertex =  1 ; vertex <= n ; vertex++ ){
            if ( coloredNodes [ vertex - 1] != 0 ) continue;
            q.offer ( vertex );
            while  ( !q.isEmpty() ) {
                int node = q.poll();
                List < Integer > children = edges.get ( node );
                boolean [] flowerType = new boolean [ 5 ];
                for ( int child : children ) flowerType [ coloredNodes [ child - 1 ] ] = true;
                for ( int color = 1 ; color  <= 4 ; color++ ) if ( !flowerType [ color ] ) {
                    coloredNodes [ node - 1 ] = color;
                    break;
                }
                // for ( int child : children ) {
                //     if ( flowerType [ coloredNodes [ child - 1 ] ] )  continue;
                //     else {
                //         for ( int color = 1 ; color <= 4 ; color++ ) {
                //             if ( !flowerType [ color ] )  {
                //                 flowerType [ coloredNodes [ child - 1 ] ]  = true;
                //                 coloredNodes [ child - 1 ] = color; 
                //             }
                //             q.offer ( child );
                //         }
                //     }
                // }
            }
        }
        return coloredNodes;
    }
}