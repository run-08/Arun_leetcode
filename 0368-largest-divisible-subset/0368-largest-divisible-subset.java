class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      HashMap<Integer , List<Integer>> hm = new HashMap<>();
      int maxCount = 0 , n = nums.length;
      int[] dp = new int[n];
      Arrays.sort(nums);
      hm.computeIfAbsent(0 , k -> new ArrayList<>()).add(nums[0]);
      dp[0] = 1;
      for(int i = 1;i < n;i++) {
        dp[i] = 1;
        List<Integer> ls = new ArrayList<>();
        for(int j = 0;j < i;j++) {
            if((nums[i] % nums[j] == 0) || (nums[j] % nums[i] == 0)){
                 if(dp[i] < dp[j]+1) {
                    ls = new ArrayList<>(hm.get(j));
                    dp[i] = dp[j]+1;
                 }
            } 
        }
        ls.add(nums[i]);
        hm.put(i , new ArrayList<>(ls));
      }
     int  max_idx = 0;
     for(int i = 1;i < n;i++) if(dp[max_idx] < dp[i]) max_idx = i;
     return hm.get(max_idx);
    }
}