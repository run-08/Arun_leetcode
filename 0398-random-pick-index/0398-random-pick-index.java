class Solution {
     HashMap<Integer , List<Integer >> hm = new HashMap<>();
     Random random = new Random();
    public Solution(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            List<Integer> ls = hm.getOrDefault(nums[i] , new ArrayList<>());
            ls.add(i);
            hm.put(nums[i], new ArrayList<>(ls));
        }
    }
    public int pick(int target) {
        return hm.get(target).get(random.nextInt(hm.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */