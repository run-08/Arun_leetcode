class Solution {
    public int findClosestNumber(int[] nums) {
        int positive_val = Integer.MAX_VALUE;
        int negative_val = Integer.MIN_VALUE;
        for(int val : nums){
            if(val == 0) return 0;
            if(val > 0) if(positive_val > val) positive_val = val;
            if(val < 0) if(negative_val < val) negative_val = val; 
        }
        if(Math.abs(negative_val) < 0) negative_val -= 1;
        return (positive_val <= Math.abs(negative_val))  ? positive_val : negative_val;
    }
}