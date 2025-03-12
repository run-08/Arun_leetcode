class Solution {
    public long continuousSubarrays(int[] nums) {
       int cur = 1 ,  max = nums[0] , min = nums[0] , n = nums.length;
       long res = 1;
       HashMap<Integer , Integer> idxes = new HashMap<>();
       idxes.put(nums[0] , 0);
       for(int i = 1;i < n ;i++){
           if(Math.abs(max-nums[i]) > 2){
            int idx = idxes.get(max);
            min = Integer.MAX_VALUE;
             max = Integer.MIN_VALUE;
             idxes.clear();
             cur = 0;
               for(;idx <= i;idx++){
                   if(Math.abs(nums[idx] - nums[i]) > 2){
                    cur = 0;
                    idxes.clear();
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                   }
                   else {
                      cur++;
                      min = Math.min(min , nums[idx]);
                      max = Math.max(max , nums[idx]);
                      idxes.put(nums[idx] , idx);
                   }
               }
               System.out.println();
           }
           else if(Math.abs(min - nums[i]) > 2){
             int idx = idxes.get(min);
             min = Integer.MAX_VALUE;
             max = Integer.MIN_VALUE;
             idxes.clear();
             cur = 0;
               for(;idx <= i;idx++){
                   if(Math.abs(nums[idx] - nums[i]) > 2){
                    cur = 0;
                    idxes.clear();
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                   }
                   else {
                      cur++;
                      min = (nums[idx] < min) ? nums[idx] : min;
                      max = (nums[idx] > max) ? nums[idx] : max;
                      idxes.put(nums[idx] , idx);
                   }
               }
           }
           else {
            cur++;
            if(max < nums[i]) max = nums[i];
            else if(min > nums[i]) min = nums[i];
            idxes.put(nums[i] , i);
           }
           res += cur;
       }
       return res;
    }
}