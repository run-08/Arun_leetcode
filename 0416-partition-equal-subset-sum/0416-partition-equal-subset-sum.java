class Solution {
    public boolean canPartition(int[] nums) {
         int sum = 0;
         for(int val : nums) sum += val;
         if(sum % 2 != 0) return false;
         int target = sum / 2;
         Boolean dp[][] = new Boolean[nums.length][target+1]; 
         return partition(nums , nums.length-1 , dp,target);
    }
     public boolean partition(int[] nums , int idx , Boolean[][] dp , int target) {
		 if(target == 0) return true;
		 if(idx < 0  || target  < 0) return false;
		 if(dp[idx][target] != null) return dp[idx][target];
		  dp[idx][target] =  partition(nums , idx-1 , dp , target) || partition(nums , idx-1 , dp , target-nums[idx]);
		 return dp[idx][target];
	 }
}