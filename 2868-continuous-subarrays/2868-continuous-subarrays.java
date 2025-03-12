class Solution {
    public long continuousSubarrays(int[] nums) {
       int cur = 1 ,  max = nums[0] , min = nums[0] , n = nums.length , min_index = 0 , max_index = 0;
       long res = 1;
       for(int i = 1;i < n ;i++){
           if(Math.abs(max-nums[i]) > 2){
            int idx = max_index;
            min = Integer.MAX_VALUE;
             max = Integer.MIN_VALUE;
             cur = 0;
               for(;idx <= i;idx++){
                   if(Math.abs(nums[idx] - nums[i]) > 2){
                    cur = 0;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                   }
                   else {
                     cur++;
                    if(min > nums[idx]){
                        min_index = idx;
                        min = nums[idx];
                    }
                    if(max < nums[idx]) {
                        max_index = idx;
                        max = nums[idx];
                    }
                   }
               }
           }
           else if(Math.abs(min - nums[i]) > 2){
             int idx = min_index;
             min = Integer.MAX_VALUE;
             max = Integer.MIN_VALUE;
             cur = 0;
               for(;idx <= i;idx++){
                   if(Math.abs(nums[idx] - nums[i]) > 2){
                    cur = 0;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                   }
                   else {
                      cur++;
                    if(min > nums[idx]){
                        min_index = idx;
                        min = nums[idx];
                    }
                    if(max < nums[idx]) {
                        max_index = idx;
                        max = nums[idx];
                    }
                   }
               }
           }
           else {
            cur++;
            if(max < nums[i]){
                 max = nums[i];
                 max_index = i;
            }
            else if(min > nums[i]) {
                min = nums[i];
                min_index = i;
            }
           }
           res += cur;
       }
       return res;
    }
}