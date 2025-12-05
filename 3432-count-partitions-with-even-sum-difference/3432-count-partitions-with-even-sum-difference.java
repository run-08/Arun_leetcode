class Solution {
    public int countPartitions(int[] nums) {
        int sum = Arrays
                 .stream(nums)
                 .reduce(0,Integer::sum);
        int res = 0, pre_sum = 0;
        for(int val : nums){
            pre_sum += val;
            sum -= val;
            if(Math.abs((sum-pre_sum)&1)==0) res++;
        }
        return res != 0 ? res - 1 : 0;
    }
}