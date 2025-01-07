class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt = 0;
        for(int i = 1;i < nums.length-1;i++){
            int count = 0;
            for(int j = i-1;j >= 0 && count == 0;j--) if(nums[i] - nums[j] == diff) count++;
            if(count == 0) continue;
            else count = 0;
            for(int j = i+1;j < nums.length && count == 0;j++) if(nums[j] - nums[i] == diff) count++;
            if(count > 0) cnt++;
        }
        return cnt;
    }
}