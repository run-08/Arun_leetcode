class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        bacres(new ArrayList<>() , res , 0 , nums , nums.length);
        return new ArrayList<>(res);
    }
    public void bacres(List<Integer> cur , HashSet<List<Integer>> res , int idx , int[] nums , int n){
        if(idx == n){
            res.add(new ArrayList<>(cur));
            return;
        } 
        cur.add(nums[idx]);
        bacres(cur , res , idx+1 , nums , n);
        cur.remove(cur.size()-1);
        bacres(cur , res , idx+1 , nums , n);
    }
}