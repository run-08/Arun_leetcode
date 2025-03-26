class Solution {
    public int maximumCandies(int[] candies, long k) {
         int s = 1 , e = 0 ;
         for(int val : candies) e = Math.max(val ,e);
         while(s <= e) {
            int m = s + (e - s ) / 2;
            long cnt = 0;
            for(long val : candies) cnt += val / m;
            if(cnt >= k) s = m + 1;
            else e = m - 1;
         }
         return e;
    }
}