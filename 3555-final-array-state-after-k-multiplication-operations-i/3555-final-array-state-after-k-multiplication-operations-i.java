class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while( k != 0){
            int min_idx = findMinValue(nums);
            nums[min_idx] *= multiplier;
            k--;
        }
        return nums;
    }
    public int findMinValue(int[] nums){
          int min_idx = 0;
          for(int i = 1;i < nums.length;i++) if(nums[min_idx] > nums[i]) min_idx = i;
          return min_idx;
    }
}