class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums[0] & 1;
        int size = nums.length-1;
        for(int i = 1;i <= size;i++){
            if((nums[i] & 1) == n) return false;
            n = nums[i] & 1;
        }
        return true;
    }
}