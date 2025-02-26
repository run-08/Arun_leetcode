class Solution {
    public int subsetXORSum(int[] nums) {
       return  bacres(nums , 0 , 0);
    }
    public int bacres (int[] nums , int idx , int sum){
         if(idx == nums.length) return sum;
         return  bacres(nums , idx+1 , sum ^ nums[idx])+ bacres(nums , idx+1 , sum);
    }
}