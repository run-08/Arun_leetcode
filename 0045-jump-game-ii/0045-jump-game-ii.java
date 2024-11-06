class Solution {
    public int jump(int[] nums) {
       int jump = 0;
        if(nums.length == 1) return 0;
         if(nums[0] == 0) return -1;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] >= (nums.length - 1) - i) return jump+1;
            jump++;
            int idx = nums[i]+i;
            int distance = nums[i]+i;
            for(int j = i+nums[i];j >= i;j--){
                int distance_in = nums[j]+j;
                if(distance_in >= distance){
                    idx = j;
                    distance = distance_in;
                }
            }
            i = idx - 1;
        }
        return -1;
    
    }
}