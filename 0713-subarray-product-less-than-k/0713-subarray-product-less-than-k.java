class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 1 , n = nums.length , idx = 0  , cnt = 0 ;
        for(int i = 0;i < n;i++) {
            // System.out.print(idx+" "+res+" "+cnt+"\n");
           res *= nums[i];
           if(res < k) cnt += (i-idx)+1;
           else if(nums[i] >= k) {
            idx = i+1;
            res = 1;
           }
           else {
            for(;idx <= i;idx++) {
                if(res < k) break;
                 res /= nums[idx];
            }
            cnt += (i-idx)+1;
           }
        }
        return cnt;
    }
}