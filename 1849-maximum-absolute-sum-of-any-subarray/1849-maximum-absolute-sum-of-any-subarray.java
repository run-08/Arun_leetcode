class Solution {
    public int maxAbsoluteSum(int[] nums) {
         int max_sum = 0;
         int cur = 0;
         int n = nums.length;
         for(int i = 0;i < n;i++){
            cur += nums[i];
            if(cur < 0)  cur = 0;
            max_sum = Math.max(cur , max_sum);
         }
         cur = 0;
         int min_sum = 0;
         for(int i = 0;i < n;i++){
            cur += nums[i];
            if(cur > 0) cur = 0;
            min_sum = Math.min(cur , min_sum);
         }
         return Math.max(max_sum , Math.abs(min_sum));
    }
}