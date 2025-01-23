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
		//  System.out.println(idx+" "+target);
		 if(target == 0) return true;
		 if(idx < 0  || target  < 0) return false;
		 if(dp[idx][target] != null) return dp[idx][target];
		 boolean exclude =  partition(nums , idx-1 , dp , target);
		 boolean include = partition(nums , idx-1 , dp , target-nums[idx]);
		 dp[idx][target] = exclude || include;
		 return dp[idx][target];
	 }
}