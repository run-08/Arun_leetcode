class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1,-1};
        if(nums.length == 0) return res;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                if(mid-1 >= 0 && nums[mid-1] == target) {
                     end = mid-1;
                     continue;
                }
                else {
                    res[0] = mid;
                    break;
                }
            }
            if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        start = 0;
        end = nums.length-1;
         while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                if(mid+1 < nums.length && nums[mid+1] == target) {
                     start= mid+1;
                     continue;
                }
                else {
                    res[1] = mid;
                    break;
                }
            }
            if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return res;
    }
   
}