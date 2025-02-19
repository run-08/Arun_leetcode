class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] flag = new boolean[n];
        HashSet<List<Integer>> hs =  new HashSet<>();
        permutate(new ArrayList<>() , flag , hs , n , nums);
        List<List<Integer>> res = new ArrayList<>(hs);
        return res;
    }
    public static void  permutate(List<Integer> cur , boolean[] flag , HashSet<List<Integer>> res , int n , int[] nums){
       if(n == cur.size()) {
          res.add(new ArrayList<>(cur));
          return;
       }
       for(int i = 0;i < n;i++) {
           if(!flag[i]){
            flag[i] = true;
             cur.add(nums[i]);
             permutate(cur , flag , res , n , nums);
             flag[i] = false;
             cur.remove(cur.size()-1);
           }
       }
    }
}