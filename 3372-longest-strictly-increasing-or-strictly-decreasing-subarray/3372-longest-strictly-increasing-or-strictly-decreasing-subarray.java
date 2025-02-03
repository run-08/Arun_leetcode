class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int dec_max = 0;
        int inc_max = 0;
        int cur_inc = 0;
        int cur_dec = 0;
        int n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i] == nums[i-1]) {
                cur_inc = 0;
                cur_dec = 0;
                continue;
            }
            if(nums[i] > nums[i-1]) {
                cur_inc++;
                if(inc_max < cur_inc) inc_max = cur_inc;
                cur_dec = 0;
            }
            else {
                cur_dec++;
                if(dec_max < cur_dec) dec_max = cur_dec;
                cur_inc = 0;
            }
        }
        return (dec_max >= inc_max) ? dec_max+1 : inc_max+1;
    }
}