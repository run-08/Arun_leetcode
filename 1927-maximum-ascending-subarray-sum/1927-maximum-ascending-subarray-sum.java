class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int inner_max = nums[0];
        int n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i] <= nums[i-1]){
                if(inner_max > max) max = inner_max;
                inner_max = nums[i];
            }
            else inner_max += nums[i];
        }
        return (inner_max  >= max) ? inner_max : max;
    }
}