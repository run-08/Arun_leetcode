class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(nums.length == 2){
            if(nums[0] > nums[1]) return 0;
            else return 1;
        }
        while(start <= end){
            int mid = (start+end)/2;
            if(mid-1 < 0 || mid+1 >= nums.length)return mid;
            if(nums[mid+1] < nums[mid] && nums[mid-1] < nums[mid]) return mid;
            else if(nums[mid-1] < nums[mid]) start = mid+1;
            else end = mid;
        }
        return 0;
    }
}