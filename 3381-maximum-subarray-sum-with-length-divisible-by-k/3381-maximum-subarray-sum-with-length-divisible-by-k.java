class Solution {
    long max=Long.MIN_VALUE;
    static final long NEG_INF = -(1L << 50); 
    public long maxSubarraySum(int[] nums, int k) {
       int n=nums.length;
       long pre_sum[] = new long[n];
       pre_sum[0]=nums[0];
       for(int i=1;i<n;i++) pre_sum[i]=pre_sum[i-1]+nums[i];
       for(int i=0;i<k;i++) helper(i,pre_sum,k);
       return max;
    }
    private long helper(int idx,long[] pre_sum,int k){
        if( idx+k-1 >= pre_sum.length) return NEG_INF;
        long ans = idx==0 ? pre_sum[k-1] :  pre_sum[idx+(k-1)]-pre_sum[idx-1];
        long sum = helper(idx+k,pre_sum,k);
        long res = (sum != NEG_INF) ? sum+ans:ans;
        max=Math.max(max,Math.max(res,ans));
        return Math.max(res,ans);
    }
}