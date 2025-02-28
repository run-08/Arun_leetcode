class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int prev = 0;
        int max = 0;
        int cnt = 0;
        if(k == 0){
            for(int val : nums){
                if(val == 1) cnt++;
                else cnt = 0;
                max = Math.max(cnt , max);
            }
            return max;
        }
        for(int i = 0;i < n;i++){
            if(nums[i] == 1) cnt++;
            else if(nums[i] == 0 && k != 0){
            k--;
            cnt++;
            }
            else {
                for(int j = prev;j < i ;j++) {
                    cnt -= 1;
                    if(nums[j] == 0) {
                        prev = j+1;
                        break;
                    }
                }
                cnt += 1;
            }
            max = Math.max(max , cnt);
        }
        return max;
    }
}