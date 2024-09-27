class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
       for(int i = 0;i < nums.length/2;i++) sum += Long.parseLong(String.valueOf(nums[i])+String.valueOf(nums[nums.length-i-1]));
      if(nums.length % 2 != 0) sum += nums[nums.length/2];
      return sum;
    }
}