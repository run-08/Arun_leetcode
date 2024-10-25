class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int cnt = 0;
        int pre_sum = 0;
        for(int val : nums) {
            pre_sum += val;
            if(hm.containsKey(pre_sum - k)) cnt += hm.get(pre_sum - k);
             hm.put(pre_sum,hm.getOrDefault(pre_sum,0)+1);
        }
        return cnt;
    }
}