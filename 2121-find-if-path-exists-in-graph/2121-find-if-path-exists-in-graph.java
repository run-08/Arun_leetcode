class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List < List < Integer > > graph = new ArrayList <> ();
        if (  destination == source ) return destination == source;
        for ( int vertex = 0 ; vertex < n ; vertex++ ) graph.add ( new ArrayList <> ( ) );
        for ( int [] edge : edges ) {
            graph.get ( edge [ 0 ] ).add ( edge [ 1 ] );
            graph.get ( edge [ 1 ] ).add ( edge [ 0 ] );
        }
        Queue < Integer > q = new ArrayDeque <> ();
        q.offer ( source );
        boolean [] visited = new boolean [ n ];
        while ( !q.isEmpty () ) {
            int node = q.poll ();
            if ( visited [ node ] ) continue;
            visited [ node ] = true;
            List < Integer > children = graph.get ( node );
            for ( int child : children ) {
                if ( visited [ child ] ) continue;
                if ( child == destination ) return true;
                q.offer ( child );
            }
        }
        return false; 
    }
}