class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int s = 0;
        int e = nums.length-1;
        while(s <= e){
            int m = (s + e)/2;
            if(m % 2 != 0){
                if(m == 0 || m == nums.length-1) return nums[m];
                if(nums[m] != nums[m+1] && nums[m] != nums[m-1]) return nums[m];
                if(nums[m-1] == nums[m]) s = m+1;
                else e = m-1;
            }
            else{
                if(m == nums.length-1 || m == 0) return nums[m];
                if(nums[m] != nums[m+1] && nums[m] != nums[m-1]) return nums[m];
                if(nums[m+1] == nums[m]) s = m+1;
                else e =  m-1;
            }
        }
        return nums[s];
    }
}