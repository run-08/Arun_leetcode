class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0 , sum = 0;
        int idx = 0 , n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < n;i++) {
            sum += nums[i];
            if(hs.contains(nums[i])) {
               while(hs.contains(nums[i])) {
                hs.remove(nums[idx]);
                sum -= nums[idx++];
               }
               hs.add(nums[i]);
            }
            else hs.add(nums[i]);
            if(hs.size() >= k) {
                res = Math.max(sum , res);
                sum -= nums[idx];
                hs.remove(nums[idx++]);
            }
        }
        return res;
    }
}