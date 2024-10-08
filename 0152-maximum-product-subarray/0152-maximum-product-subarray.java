class Solution {
    public int maxProduct(int[] nums) {
    //    int product = 0;
    //    int max = Integer.MIN_VALUE;
    //    for(int i = 0;i < nums.length;i++){
    //     product = nums[i];                           // O ( N ^ 2 )
    //     max = (product < max) ? max : product;
    //     for(int j = i+1;j < nums.length;j++){
    //         product *= nums[j];
    //         max = (product < max) ? max : product;
    //     }
    //    }
    //    return max;
     int prefix_sum = Integer.MIN_VALUE;
     int suffix_sum = Integer.MIN_VALUE;
     int product = 1;
     for(int val : nums){
         if(val == 0){
            product = 1;
            if( prefix_sum < 0) prefix_sum =0;
            continue;
         }
         product *= val;
         if(product > prefix_sum) prefix_sum = product;
     }
     product = 1;
     for(int i = nums.length-1;i >= 0;i--){
         if(nums[i] == 0){
            product = 1;
            if( suffix_sum < 0) suffix_sum =0;
            continue;
         }
         product *= nums[i];
         if(product > suffix_sum) suffix_sum = product;
     }
     return (prefix_sum > suffix_sum) ? prefix_sum : suffix_sum;
    }
}