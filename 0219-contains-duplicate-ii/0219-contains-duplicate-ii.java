class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap hm = new HashMap<>();
        for(int i = 0;i < k && i < nums.length;i++){
            if(hm.containsKey(nums[i])) return true;
            else hm.put(nums[i],1);
        }
        int idx = 0;
        System.out.print(hm);
        for(int i = k;i < nums.length;i++){
            if(hm.containsKey(nums[i])) return true;
            else hm.put(nums[i],1);
            hm.remove(nums[idx++]);
        }
        return false;
    }
}