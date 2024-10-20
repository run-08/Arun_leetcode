class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] sub1 = new int[nums.length/2];
        int[] sub2 = new int[nums.length/2];
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] < 0) sub1[idx1++] = nums[i];
            else sub2[idx2++] = nums[i];
        }
        idx1 = 0;
        for(int i = 0;i < nums.length;i++) {
            nums[i] = sub2[idx1];
            nums[++i] = sub1[idx1++];
        }
        return nums;
    }
}