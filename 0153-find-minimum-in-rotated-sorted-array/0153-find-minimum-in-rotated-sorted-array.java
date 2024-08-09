class Solution {
    public int findMin(int[] nums) {
       int s = 0;
       int e = nums.length-1;
       while(s < e){
        int mid = (s+e)/2;
        if(mid-1 >= 0 && nums[mid-1] > nums[mid]) return nums[mid];
        if(mid+1 < nums.length && nums[mid+1] < nums[mid]) return nums[mid+1];
        if(nums[mid] < nums[e]) e = mid-1;
        else s = mid+1;
       }
       return nums[s];
    }
}