class Solution {

    int [] dp;
    int [] count;
    List < List < Integer > > graph;
    int lastNode;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

       this.graph = new ArrayList <> ();
       this.count = new int [ n ];
       this.dp = new int [ n ];
       this.lastNode = n;

       for ( int node = 0 ; node < n ; node++ ) graph.add( new ArrayList <> () );

       for ( int [] edge : edges ) {

            graph.get ( edge [ 0 ] ).add ( edge [ 1 ] );
            graph.get ( edge [ 1 ] ).add ( edge [ 0 ] );

       }

      Arrays.fill ( count, -1 );

      int [] sumOfDistancesInTree = new int [ n ] ;

      dfs ( 0, -1 );

      Queue < int [] > q = new ArrayDeque <> ();

      q.offer( new int [ ] { 0, -1 } );
      sumOfDistancesInTree [ 0 ] = dp [ 0 ];

      while ( !q.isEmpty() ) {

           int [] cell = q.poll();
           int parent = cell [ 0 ], grantParent = cell [ 1 ];

           for ( int child : graph.get ( parent ) ) {

                 if ( child == grantParent ) continue;
                  sumOfDistancesInTree [ child ] = sumOfDistancesInTree [ parent ] - count [ child ] + ( n - count [ child ] );  
                 q.offer ( new int [] { child, parent } );
           }

      }

    //   System.out.print( Arrays.toString ( dp ) + " " + Arrays.toString ( count ) );

      return sumOfDistancesInTree;
        
    }

    private int dfs( int parentNode, int grandParent ) {

        if ( count [ parentNode ] != -1 ) return count [ parentNode ];

        int countSubPath = 0;

        for ( int childNode : graph.get ( parentNode ) ) {

            if ( childNode == grandParent ) continue;

           int  path = dfs ( childNode, parentNode );

           dp [ parentNode ] += dp [ childNode ] + count [ childNode ];

           countSubPath += path ; 
 
        }

        return count [ parentNode ] = 1 + countSubPath;
         
    }
}