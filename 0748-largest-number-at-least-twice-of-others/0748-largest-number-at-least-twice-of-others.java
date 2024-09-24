class Solution {
    public int dominantIndex(int[] nums) {
        int Largest1 = (nums[0] > nums[1]) ? nums[0] : nums[1];
        int Largest2 = (nums[0] > nums[1]) ? nums[1] : nums[0];
        int Largest1Index =  (nums[0] > nums[1]) ? 0 : 1; 
        for(int i = 2;i < nums.length;i++){
            if(nums[i] > Largest1) {
                Largest2 = Largest1;
                Largest1 = nums[i];
                Largest1Index = i;
            }
            else if(nums[i] > Largest2) Largest2 = nums[i];
            else continue;
        }
       return (Largest2*2 <= Largest1) ?  Largest1Index : -1; 
    }
}