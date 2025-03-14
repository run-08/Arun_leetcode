class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0 , left = -1 , n = nums.length , cur = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < n;i++){
            cur += nums[i];
            if(hs.contains(nums[i])){
                left += 1;
                for(;left < i;left++) {
                    cur -= nums[left];
                    if(nums[left] == nums[i]) break;
                    hs.remove(nums[left]);
                }
            }
            else hs.add(nums[i]);
            //  System.out.print(cur+" "+i+" "+left+"\n");
            res = Math.max(res , cur);
        }
        return res;
    }
}