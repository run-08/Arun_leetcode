class Solution {
    public boolean isBipartite(int[][] graph) {
        List < List < Integer > > edges = new ArrayList <> ();
        int maxVertex = 0;
        for( int [] edge : graph ) for ( int node : edge ) maxVertex = Math.max ( maxVertex , node );
        for( int vertice = 0 ; vertice <= maxVertex ; vertice++ ) edges.add ( new ArrayList<>() );
        int [] colored = new int [ maxVertex + 1 ];
        int V = graph.length;
        for( int vertice = 0 ; vertice < V ; vertice++ ) {
            for( int node : graph [ vertice ] ) {
                edges.get( node ).add ( vertice );
                edges.get( vertice ).add ( node );
            }
        }
        Arrays.fill ( colored , -1 );
        for( int vertice = 0 ; vertice <= maxVertex ; vertice++ ) {
            if ( colored [ vertice ] != -1 ) continue;
            colored [ vertice ] = 1;
            Queue < Integer > q = new ArrayDeque <> ();
            q.offer ( vertice );
            while ( !q.isEmpty() ) {
                int node = q.poll();
                List < Integer > children = edges.get( node );
                for( int child : children ) {
                    if ( colored [ child ] == -1 ) {
                        colored [ child ] = 3 - colored [ node ];
                        q.offer ( child );
                    }
                    else if ( colored [ child ] == colored [ node ] ) return false;
                }
            }
        }
        return true;
    }
}