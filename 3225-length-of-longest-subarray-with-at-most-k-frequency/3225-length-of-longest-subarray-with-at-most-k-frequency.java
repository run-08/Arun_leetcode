class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int idx = -1 , res = 0 , n = nums.length;
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i = 0;i < n;i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0)+1);
            if(hm.get(nums[i]) > k) {
                idx += 1;
                for(;idx < i;idx++){
                    if(nums[idx] == nums[i]) {
                        hm.put(nums[idx] , hm.getOrDefault(nums[idx] , 1) -1);
                        break;
                    }
                    else hm.put(nums[idx] , hm.getOrDefault(nums[idx] , 1)-1);
                }
            }
            res = Math.max((i-idx) , res);
        }
        return res;
    }
}