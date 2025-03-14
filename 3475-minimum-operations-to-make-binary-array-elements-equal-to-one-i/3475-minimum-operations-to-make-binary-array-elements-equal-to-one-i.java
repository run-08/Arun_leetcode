class Solution {
    public int minOperations(int[] nums) {
       int cnt = 0 , n = nums.length ;
       boolean isZero  = false;
       for(int i = 0;i < n-2;i++) {
        if(nums[i] == 0) {
            cnt++;
            nums[i] ^= 1;
            nums[i+1] ^= 1;
            nums[i+2] ^= 1;
        }
       }
        for(int i = 0;i < n && !isZero;i++) if(nums[i] == 0) isZero = true;
        return (isZero) ? -1 : cnt;
    }
}