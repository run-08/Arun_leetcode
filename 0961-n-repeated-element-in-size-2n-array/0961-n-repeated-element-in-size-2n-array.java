class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) if(!set.add(val)) return val;
        return -1;
    }
}