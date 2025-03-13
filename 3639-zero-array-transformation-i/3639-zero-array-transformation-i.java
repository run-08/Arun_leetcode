class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int[] arr : queries){
            int start = arr[0];
            int end = arr[1];
            ans[start] -= 1;
            if(end+1 < n) ans[end+1] += 1;
        }
        for(int i = 1;i < n;i++) ans[i] += ans[i-1];
        for(int i = 0;i < n;i++) {
            nums[i] += ans[i];
            if(nums[i] > 0) return false;
        }
        return true;
    }
}