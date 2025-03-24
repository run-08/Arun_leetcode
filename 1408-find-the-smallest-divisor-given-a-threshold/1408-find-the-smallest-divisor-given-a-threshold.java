class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1 , e = 0 , n = nums.length , max  = 0;
        for(int i = 0;i < n;i++) e = Math.max(e , nums[i]);
        while(l <= e) {
            int m = l + ( e - l ) / 2;
            int cnt = 0;
            for(int val : nums) {
              cnt += val / m;
              if((val % m) != 0) cnt += 1;
            }
            if(cnt > threshold) l = m + 1;
            else e = m - 1;
        }
        return l;
    }
}