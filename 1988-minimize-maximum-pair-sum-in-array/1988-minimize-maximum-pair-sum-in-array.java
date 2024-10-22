class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0;i < nums.length / 2;i++) if(nums[i]+nums[nums.length-i-1] > res) res = nums[i]+nums[nums.length-i-1] ;
        return res;
    }
}