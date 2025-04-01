class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        for(int i = 1;i < n;i++) nums[i] += nums[i-1];
    }
    
    public int sumRange(int left, int right) {
        int idx = left-1;
        if(idx < 0) return nums[right];
        return nums[right]-nums[idx];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */