class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
         int res = 0 , n = nums.length , cur = 0, idx = 0 , prev = 0;
         for(int i = 0;i < n;i++) {
           if(nums[i] > right) {
               cur = i+1;
               idx = i+1;
               prev = 0;
           }
           else {
             if(nums[i] >= left){
                cur = i;
                res += (cur-idx)+1;
                prev = (cur-idx)+1;
             }
             else res += prev;
           }
         }
         return res;
    }
}