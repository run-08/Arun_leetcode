class Solution {
    HashMap < Integer , int[] > dp;
    String labels;
    List < List < Integer> > graph;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        dp = new HashMap<>();
        this.labels = labels;
        graph = new ArrayList <> ();
        for ( int vertex = 0 ;  vertex < n ; vertex++ ) graph.add ( new ArrayList <> () );
        for ( int[] vertex : edges  ) {
            graph.get( vertex [ 0 ] ).add ( vertex [ 1 ] );
            graph.get ( vertex [ 1 ] ).add ( vertex [ 0 ] );
        }
        for ( int vertex  = 0 ; vertex < n ; vertex++ ) if  ( !dp.containsKey ( vertex ) ) dfs ( vertex , -1 );
       int [] subTreesCount = new int [ n ];
       for ( int vertex = 0 ; vertex < n ; vertex++ ) {
          int [] vertextSubCount = dp.get ( vertex );
          subTreesCount [ vertex ] = vertextSubCount [ labels.charAt(vertex) - 97 ];
       }
       return subTreesCount;
    }
    private int[] dfs ( int node  , int parent ) {
        if ( dp.containsKey ( node ) ) return dp.get ( node );
        List < Integer > children = graph.get ( node );
        int[] labelFreq = new int [ 26 ];
        labelFreq [ labels.charAt ( node ) - 97 ]++;
        for ( int child : children ) {
            if ( child == parent ) continue;
            int [] labeledFrequency = dfs ( child , node );
            for ( int label = 0 ; label < 26 ; label++ ) labelFreq [ label ] += labeledFrequency [ label ];
        }
        dp.put ( node , labelFreq  );
        return labelFreq;
    }
}