class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int sum = 0;
        List<Boolean> res = new ArrayList<>();
        for(int val:nums){
            sum = (sum * 2 + (val))%5;
            res.add(sum % 5 == 0);
        }
        return res;
    }
}