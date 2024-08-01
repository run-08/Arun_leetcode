
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while(s <= e){
            int mid = ((s+e))/2;
            if(mid-1 >=0 && mid+1 < nums.length){
                if(nums[mid] > nums[mid+1] &&  nums[mid-1] < nums[mid]) return mid;
            }
            if(nums[mid+1] < nums[mid]) e=mid-1;
            else s = mid+1;
        }
        return 0;
    }
}