class Solution {
    public int maxAdjacentDistance(int[] nums) {
       int max = 0 , n =  nums.length;
       for(int i = 0;i < n;i++){
          if(i == n-1){
            max = Math.max(max , Math.abs(nums[i]-nums[0]));
          }
          else max = Math.max( max , Math.abs(nums[i]-nums[i+1]));
       } 
       return max;
    }
}