class Solution {

    boolean [] visited;
    int target,n;
    int [] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        this.n = nums.length;
        this.visited = new boolean [ n ];
        this.nums = nums;
        
        int sum = 0;

        for ( int val : nums ) sum += val;
 
        this.target = sum / k;
        if ( sum % k != 0 ) return false;

        return dfs ( 0, 0, k );

    }

    private boolean dfs ( int idx, int sum, int k ) {
 
        if ( k == 1 ) return true;
        
        if ( sum == target ) return dfs ( 0, 0, k - 1 );

        for ( int index = idx; index < n ; index++ ) {

            if ( visited [ index ] || sum + nums [ index ] > target ) continue;

            visited [ index ] = true;

            if ( dfs ( index + 1, sum + nums [ index ], k ) ) return true;

            visited [ index ] = false;

        }

        return false;

    }
}