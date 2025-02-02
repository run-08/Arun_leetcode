class Solution {
    public boolean check(int[] nums) {
       boolean flag = false;
       int n = nums.length;
       for(int i = 1;i < n;i++){
        if(nums[i-1] <= nums[i]) continue;
        else if(nums[0] >= nums[n-1] && !flag) flag = true;
        else return false;
       }
       return true;
    }
}