class Solution {
    public int findMinDifference(List<String> t) {
        int[] nums = new int[t.size()];
        for(int i = 0;i < nums.length;i++){
            String arr[] = t.get(i).split(":");
            nums[i] = Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
            }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length-1;i++) min = Math.min(min,nums[i+1]-nums[i]);
        return Math.min(min,1440-(nums[nums.length-1] - nums[0]));
    }
}