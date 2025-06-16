class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length , max = 0;
        int[] less = new int[n];
        less[0] = nums[0];
        for(int i = 1;i < n;i++) less[i] = Math.min( nums[i] , less[i-1] );
        for(int i = n-1;i >= 0;i--) if(less[i] < nums[i] )max = Math.max( max , Math.abs(nums[i] - less[i]));
        return max != 0 ? max : -1;
    }
}