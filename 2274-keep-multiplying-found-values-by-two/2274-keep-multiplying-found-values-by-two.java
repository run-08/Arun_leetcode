class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) set.add(val);
        while(set.contains(original)) original *= 2;
        return original;
    }
}