class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List < List < Integer > > edges = new ArrayList<>();
        int maxVertex = 0;
        for( int [] dislike : dislikes ) maxVertex = Math.max ( maxVertex , Math.max ( dislike [ 0 ] , dislike [ 1 ] ) );
        for( int vertex = 0 ; vertex <= maxVertex ; vertex++ ) edges.add ( new ArrayList <> () );
        int [] colored = new int [ maxVertex + 1 ];
        Arrays.fill ( colored , -1 );
        for (int dislike [] : dislikes ) {
            edges.get ( dislike [ 0 ] ).add ( dislike [ 1 ] );
            edges.get ( dislike [ 1 ] ).add ( dislike [ 0 ] );
        }
        for( int vertex = 0 ; vertex <= maxVertex ; vertex++ ) {
            if ( colored [ vertex ] != -1  ) continue;
            Queue < Integer > q = new ArrayDeque <> ();
            q.offer ( vertex );
            colored [ vertex ] = 1;
            while ( !q.isEmpty() ) {
                int node = q.poll();
                List < Integer> children = edges.get ( node );
                for( int child : children ) {
                    if( colored [child ] == colored [ node ] ) return false;
                    else if( colored [ child ] == -1 ) {
                        colored [ child ] = 3 - colored [ node ];
                        q.offer( child );
                    }
                }
            }
        }
        return true;
    }
}