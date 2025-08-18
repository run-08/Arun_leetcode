class Solution {

    public int minNumberOperations(int[] target) {
        
        int targetSize = target.length , minNumberOperations = target [ 0 ];

        for ( int index = 1 ; index < targetSize ; index++ ) if ( target [ index ] > target [ index - 1 ] ) minNumberOperations +=  target [ index ] - target [ index - 1 ];

        return minNumberOperations;

    }
}