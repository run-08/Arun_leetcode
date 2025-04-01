class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int sum = 0 , n = nums.length , max = 0;
        for(int i = 0;i < n;i++) {
            sum += ((nums[i] & 1) == 0) ? -1 : nums[i];
            if(hm.containsKey(sum)) max = Math.max(max , (i-hm.get(sum)));
            else if(sum != 0) hm.put(sum , i);
            if(sum == 0) max = i+1;
        }
        return max;
    }
}