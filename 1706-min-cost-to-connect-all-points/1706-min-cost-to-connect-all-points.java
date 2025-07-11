class Solution {
    public int minCostConnectPoints(int[][] points) {
        int pointsSize = points.length , MSTWeight  = 0;
        boolean [] visited = new boolean [ pointsSize ];
        PriorityQueue < int [] > minHeap = new PriorityQueue <> ( ( a , b ) -> a [ 1 ] - b [ 1 ] ) ; // weight , node 
        minHeap.offer ( new int [] { 0 , 0 } );
        while ( !minHeap.isEmpty() ) {
            int [] edge = minHeap.poll();
            int node = edge [ 0 ] , weight = edge [ 1 ];
            if ( visited [ node ] ) continue;
            visited [ node ] = true;
            MSTWeight += weight;
            for( int vertex = 0 ; vertex < pointsSize ; vertex++ ){
                if ( visited [ vertex ] ) continue;
                int manhattanDistance = calculateManhattanDistance ( points [ node ] , points [ vertex ] );
                minHeap.offer ( new int [] { vertex , manhattanDistance } );
            }
        }
        return MSTWeight;
    }
    private int calculateManhattanDistance ( int [] point1 , int [] point2 ) {
        return Math.abs ( point1 [ 0 ] - point2 [ 0 ] ) + Math.abs ( point1 [ 1 ] - point2 [ 1 ] );
    }
}