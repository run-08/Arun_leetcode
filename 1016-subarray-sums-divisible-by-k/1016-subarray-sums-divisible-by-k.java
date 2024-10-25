class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int pre_sum = 0;
        int count = 0;
        for(int val : nums){
           pre_sum += val;
           if(hm.containsKey((pre_sum % k + k) % k)) count += hm.get((pre_sum % k + k) % k);
           hm.put((pre_sum % k + k) % k ,hm.getOrDefault((pre_sum % k + k) % k , 0)+1);
        }
        return count;
    }
}