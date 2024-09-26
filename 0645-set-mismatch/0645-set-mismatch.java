class Solution {
    public int[] findErrorNums(int[] nums) {
      boolean[] Check = new boolean[nums.length];
      int duplicate = 0;
      int sum = 0;
      for(int val : nums) {
        sum += val;
        if(Check[val-1] == true) duplicate = val;
        else Check[val-1] = true;
      }
      return new int[]{duplicate,nums.length*(nums.length+1)/2-(sum-duplicate)};
    }
}