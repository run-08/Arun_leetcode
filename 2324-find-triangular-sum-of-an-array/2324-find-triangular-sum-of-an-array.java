class Solution {
    public int triangularSum(int[] nums) {
         List<Integer> ls = new ArrayList<>();
         if(nums.length == 1) return nums[0];
         for(int val : nums) ls.add(val);
         while(true) {
         List<Integer> current  = new ArrayList<>();
         for(int i = 0;i < ls.size()-1;i++) current.add( (ls.get(i)+ls.get(i+1)) % 10);
         ls = current;
         if(ls.size() < 2) break;
         }
         return ls.get(0);
    }
}