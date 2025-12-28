class Solution {
    public int countNegatives(int[][] grids) {
        int n = grids.length;
        return Stream
            .iterate(0, no -> no < n , no -> no + 1)
            .map( i -> grids[i])
            .map(this::countNeg)
            .reduce(0,Integer::sum);
    }
    private  int countNeg(int[] arr){
        int n = arr.length;
         return (int) Stream
                 .iterate(0, no -> no < n , no -> no + 1)
                 .mapToInt( i -> arr[i])
                 .filter( i -> i < 0 )
                //  .reduce(0 , (a,b) -> a + 1);
                .count();
    }
}