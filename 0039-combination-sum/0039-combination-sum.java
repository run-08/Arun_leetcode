class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>> hs = new HashSet<>();
        cominationWays(nums , target , 0 , hs ,new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> ls : hs) res.add(ls);
        return res;
    }
    public void cominationWays(int[] nums , int target , int idx , HashSet<List<Integer>> res , List<Integer> cur){
    
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || idx >= nums.length) return;
        for(int i = idx;i < nums.length;i++) {
            cur.add(nums[i]);
            cominationWays(nums , target-nums[i] , i+1 , res , new ArrayList<>(cur));
            cominationWays(nums , target-nums[i] , i , res , new ArrayList<>(cur));
            cur.remove(cur.size()-1);
        }
    }
}