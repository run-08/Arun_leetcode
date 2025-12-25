import java.util.Arrays;
class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        int count = 0;
        int check= 0;
        for(int i = nums.length-1; check < k;i--){
            if(nums[i]-count >= 0){
                res += nums[i]-count;

                count++;
                }
            check++;
            }
        return res;
    }
}