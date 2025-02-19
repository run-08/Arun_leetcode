class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
     HashSet<List<Integer>> res = new HashSet<>();
     int n = nums.length;
     bacres(new ArrayList<>() , 0, res , nums);
     return new ArrayList<>(res);
    }
    static public void bacres(List<Integer> ls , int idx ,HashSet<List<Integer>> res , int[] nums){
        if(ls.size() > 1) res.add(new ArrayList<>(ls));
       if(idx == nums.length) return;
       if(ls.size() == 0 || ls.get(ls.size()-1) <= nums[idx]) {
        ls.add(nums[idx]);
        bacres(ls , idx+1 , res , nums);
        ls.remove(ls.size()-1);
       }
        bacres(ls , idx + 1 , res , nums);
    }
}