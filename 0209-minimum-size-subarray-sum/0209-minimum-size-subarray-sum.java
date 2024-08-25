class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int high = 0;
        int low = 0;
        int currentsum = 0;
        int minLength = Integer.MAX_VALUE;
        while(high < nums.length){
            currentsum += nums[high++];
            while(currentsum >= target){
                minLength = (high-low < minLength) ? (high - low) : minLength;
                 currentsum -= nums[low++];
            }
        }
        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }
}