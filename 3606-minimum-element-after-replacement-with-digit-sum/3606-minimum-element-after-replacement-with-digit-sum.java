class Solution {
    public int minElement(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int sum = 0;
             while(nums[i] != 0){
                   sum += nums[i] % 10;
                   nums[i] /= 10;
             }
             res[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++) if(res[i] < min) min = res[i];
        return min;
    }
}