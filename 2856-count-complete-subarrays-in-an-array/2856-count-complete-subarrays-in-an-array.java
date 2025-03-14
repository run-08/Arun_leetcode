class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int val : nums) hm.put(val , 0);
        int total_size = hm.size() , idx = 0 , n = nums.length , res= 0;
        boolean isReached = false;
        hm.clear();
        for(int i = 0;i < n;i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0)+1);
            if(!isReached) if(hm.size() == total_size) isReached = true;
            if(isReached){
                for(;idx < i;idx++) {
                    if(hm.get(nums[idx]) <= 1) break;
                    else {
                        if(hm.get(nums[idx]) == 1) hm.remove(nums[idx]);
                        else hm.put(nums[idx] , hm.get(nums[idx])-1);
                    }
                }
                res += (idx)+1;
            }
        }
        return res;
    }
}