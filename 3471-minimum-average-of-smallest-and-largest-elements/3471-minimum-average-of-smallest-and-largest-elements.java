class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
         double min  = 51;
        for(int i = 0;i < nums.length/2;i++) if((nums[i]+nums[nums.length-i-1]) / 2.0 < min) min = ((nums[i]+nums[nums.length-i-1]) / 2.0);
        return min;
    }
}