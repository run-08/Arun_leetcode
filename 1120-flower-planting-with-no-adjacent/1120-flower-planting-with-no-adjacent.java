class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List < List < Integer > > edges = new ArrayList <> ();
        for ( int vertex = 0 ; vertex <= n ; vertex++ ) edges.add ( new ArrayList <> () );
        for ( int [] path : paths ) {
            edges.get ( path [ 0 ] ).add ( path [ 1 ] );
            edges.get ( path [ 1 ] ).add ( path [ 0 ] );
        }
        int [] coloredNodes = new int [ n  ];
        for ( int vertex =  1 ; vertex <= n ; vertex++ ){
                if ( coloredNodes [ vertex - 1] != 0 ) continue;
                List < Integer > children = edges.get ( vertex );
                boolean [] flowerType = new boolean [ 5 ];
                for ( int child : children ) flowerType [ coloredNodes [ child - 1 ] ] = true;
                for ( int color = 1 ; color  <= 4 ; color++ ) if ( !flowerType [ color ] ) {
                    coloredNodes [ vertex - 1 ] = color;
                    break;
                }
        }
        return coloredNodes;
    }
}