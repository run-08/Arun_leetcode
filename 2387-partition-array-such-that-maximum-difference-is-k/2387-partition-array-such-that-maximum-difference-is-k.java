class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0 , n = nums.length , res = 1 , min = nums[0] , max = 0;
        for(int i = 0;i < n;i++) {
            max = nums[i];
            if( ( max - min ) > k ) {
                res++;
                min = nums[i];
            }
        }
        return res;
    }
}