class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Float> hs = new HashSet<>();
        for(int i = 0;i < nums.length / 2;i++)  hs.add((float)((nums[i]+nums[nums.length-1-i] )/2.0));
        return hs.size();
    }
}