class Solution {
    public long countSubarrays(int[] nums, int k) {
      long res = 0;
      int n = nums.length , idx = -1 , max = Integer.MIN_VALUE;
      for(int val : nums) max = Math.max(max , val);
      for(int i = 0;i < n;i++){
        if(nums[i] == max && k > 0){
            k--;
            if(idx == -1) idx = i;
        } 
        else if(nums[i] == max && k <= 0){
            idx += 1;
            for(;idx <= i;idx++) if(nums[idx] == max) break;
        }
        if(k <= 0) res += idx+1;
      }
      return res;
    }
}