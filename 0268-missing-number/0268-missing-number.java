import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int total_val = (nums.length*(nums.length+1)/2);
        for(int val : nums) sum += val;
        return total_val - sum;
    }
}