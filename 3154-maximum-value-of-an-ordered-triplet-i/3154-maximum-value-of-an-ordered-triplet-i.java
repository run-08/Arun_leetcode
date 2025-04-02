class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int suf[] = new int[n] ; int[] pre = new int[n];
        long max = 0;
        for(int i = 0;i < n;i++) {
            max = Math.max(nums[i] , max);
            pre[i] = (int)max;
        }
        max = 0;
        for(int i = n-1;i >=0;i--){
            max = Math.max(nums[i] , max);
            suf[i] = (int)max;
        }
        max = 0;
        for(int i = 1;i < n-1;i++) {
            long res = (pre[i-1] - nums[i]);
            res *= suf[i+1];
            // System.out.print(res);
            max = Math.max(res , max);
        }
        return max < 0 ? 0 : max;
    }
}