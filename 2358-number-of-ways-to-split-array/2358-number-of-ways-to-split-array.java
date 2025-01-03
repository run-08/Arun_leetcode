class Solution {
    public int waysToSplitArray(int[] nums) {
        long prefix_sum = 0;
        for(int val : nums) prefix_sum += val;
        long partial_prefix_sum = 0;
        int validsubArray = 0;
        for(int i = 0;i < nums.length-1;i++) {
           partial_prefix_sum +=  nums[i];
           if((prefix_sum - partial_prefix_sum) <= partial_prefix_sum ) validsubArray++;
        }
        return validsubArray;
    }
}