class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
       int n = nums.length , res  = 0 ,  idx = 0 , prev = 0;
       if(n == 1 || n == 2) return 0;
       prev = nums[0] - nums[1];
       for(int i = 1;i < n-1;i++){
        if((nums[i]-nums[i+1]) == prev) res += (i-idx);
        else {
            idx = i;
            prev = nums[i]-nums[i+1];
        }
       }
       return res;
    }
}