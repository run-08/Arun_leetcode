class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int complement,currentNumber;
        int[] resultindex = new int[2];
        for(int i =0;i<nums.length;i++){
              currentNumber = nums[i];
              complement = target-currentNumber;
              if(map.containsKey(complement)){
                  resultindex[0] = i;
                  resultindex[1] = map.get(complement);
                  return resultindex;
              }
          else{
            map.put(currentNumber,i);
          }        
       }
       return new int[]{-1, -1};
    }
}
/*
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowSize = mat.length , colSize = mat [ 0 ].length;
        int [] [] dp = new int [ rowSize ] [ colSize ];
        for ( int [] arr : dp ) Arrays.fil( arr , Integer.MAX_VALUE - 1  );
        for ( int index = 0 ; index < rowSize ; index++ ) {
            for ( int index2 = 0 ; index2 < colSize ; index2++ ) {
                if ( grid [ index ] [ index2 ] == 0 ) {
                    dp [ index ] [ index1 ] = 0;
                    continue;
                }
                Queue < int []  > q = new ArrayList <> ();
                q.offer ( new int [] { index , index1 , 0 } );
                while ( !q.isEmpty() ) {
                    int [] adjacent = q.pol();
                    int row = adjacent [ 0 ] , col = adjacent [ 1 ] , steps = adjacent [ 2 ];
                    if ( dp [ index ] [ index1 ] != Integer.MAX_VALUE ) {
                        dp [ index ] [ index1 ] = steps;
                        break;
                    }
                    int minDistance = Integer.MAX_VALUE  selectedRow = row , selectedColumn = 
                    if ( row + 1 < rowsize && minDistance >= dp [ row + 1 ] [ col ] ) {
                        
                    }
                }
            } 
        }
    }
} */