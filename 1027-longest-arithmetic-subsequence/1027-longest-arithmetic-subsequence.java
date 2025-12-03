class Solution {
    int[][] dp;
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        dp = new int[n][1002];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(nums,-501,0,n);
    }
    private int helper(int[] nums,int diff, int idx, int n){
        if(idx==n) return 0;
        int max = 1;
        if(dp[idx][diff+501] != -1) return dp[idx][diff+501];
        if(diff==-501) for(int i=idx+1;i<n;i++) max = Math.max(1+helper(nums,nums[i]-nums[idx],i,n),Math.max(max,helper(nums,diff,i,n)));
        else for(int i=idx+1;i<n;i++) if(nums[i]-nums[idx]==diff) max = Math.max(max,1+helper(nums,nums[i]-nums[idx],i,n));
        return dp[idx][diff+501]=max;
    }
}