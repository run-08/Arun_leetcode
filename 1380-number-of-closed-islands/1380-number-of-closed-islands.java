class Solution {

    boolean [] [] visited;
    int row,col;
    int [] [] grid;
    int [] [] directions;

    public int closedIsland(int[][] grid) {

        this.grid = grid;
        this.row = grid.length; col = grid [ 0 ].length;
        this.visited = new boolean [ row ] [ col ];
        int closedIsland = 0;
        int [] [] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        this.directions = dir;

        for ( int index = 0 ; index < row ; index++ ) {

            for ( int index1 = 0 ; index1 < col ; index1++ ) {
 
                if ( grid [ index ] [ index1 ] == 1 || visited [ index ] [ index1 ] ) continue;
                else if ( dfs( index , index1 ) ) closedIsland++;

            }

        } 

        return closedIsland;   

    }

    private boolean dfs ( int r, int c ) {

        if ( r < 0 || c < 0 || r >= row || c >= col ) return false;

        if ( visited [ r ] [ c ] || grid [ r ] [ c ] == 1 ) return true;

        visited [ r ] [ c ] = true;

        boolean isAdjacentCoveredWithWater = true;

        for ( int [] dir : directions ) isAdjacentCoveredWithWater = isAdjacentCoveredWithWater && dfs( dir [ 0 ] + r, dir [ 1 ] + c );

        return visited [ r ] [ c ] = isAdjacentCoveredWithWater;

    }
}