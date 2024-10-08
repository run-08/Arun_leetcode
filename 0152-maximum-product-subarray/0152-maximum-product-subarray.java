class Solution {
    public int maxProduct(int[] nums) {
       int product = 0;
       int max = Integer.MIN_VALUE;
       for(int i = 0;i < nums.length;i++){
        product = nums[i];
        max = (product < max) ? max : product;
        for(int j = i+1;j < nums.length;j++){
            product *= nums[j];
            max = (product < max) ? max : product;
        }
       }
       return max;
    }
}