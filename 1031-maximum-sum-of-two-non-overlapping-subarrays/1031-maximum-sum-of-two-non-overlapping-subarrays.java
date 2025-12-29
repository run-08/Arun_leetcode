class Solution {
    int[][][][] dp;
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int  n = nums.length;
        dp = new int[n][3][2][2];
        for(int i=0;i<n;i++) for(int j=0;j<3;j++) for(int k=0;k<2;k++ ) Arrays.fill(dp[i][j][k],-1);
        int[] pre_sum = new int[n];
        pre_sum[0] = nums[0];
        for(int i=1;i<n;i++) pre_sum[i] = nums[i]+pre_sum[i-1];
        return helper(pre_sum,firstLen,secondLen,n,0,0);
    }
    private int helper(int[] nums,int f,int l,int n,int i,int t){
        if(t==2 || i >= n) return 0;
        int lAvailable = f == -1 ? 0 : 1,rAvailable = l == -1 ? 0 : 1;
        if(dp[i][t][lAvailable][rAvailable] != -1) return dp[i][t][lAvailable][rAvailable];
        //  skip...
        int non_taken = helper(nums,f,l,n,i+1,t);
        // taken...
        if(t==1){
            int taken = 0;
            int len = f != -1 ? f : l;
            if(i+len<= n ) {
                if(i!=0) taken = (nums[i+len-1]-nums[i-1])+helper(nums,f,l,n,i+len,2);
                else taken = nums[i+len-1]+helper(nums,f,l,n,i+len,2);
            }
            return dp[i][t][lAvailable][rAvailable] = Math.max(non_taken,taken);
        }
        else{
             int taken = 0;
             if(i == 0) {
                int f_l = (i+f - 1 <= n ) ? nums[i+f-1]+helper(nums,-1,l,n,i+f,1) : 0;
                int s_l = (i+l -1 <= n ) ? nums[i+l-1]+helper(nums,f,-1,n,i+l,1) : 0;
                taken = Math.max(f_l,s_l);
             }
             else {
                int f_l = (i+f - 1 < n ) ? (nums[i+f-1]-nums[i-1])+helper(nums,-1,l,n,i+f,1) : 0;
                int s_l = (i+l -1 < n ) ? (nums[i+l-1]-nums[i-1])+helper(nums,f,-1,n,i+l,1) : 0;
                taken = Math.max(f_l,s_l);
            }
             return dp[i][t][lAvailable][rAvailable] = Math.max(non_taken,taken);
        }
    }
}