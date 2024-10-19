class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i < nums.length;i++) for(int j = 0;j < i;j++)  if(nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
        int max = Integer.MIN_VALUE;
        for(int val : dp) if(val > max) max = val;
        return max;
    }
}