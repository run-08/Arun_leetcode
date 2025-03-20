class Solution {
    int b , f;
    public int minDays(int[] bloomDay, int m_days, int k) {
        b = m_days;
        f = k;
        int s = Integer.MAX_VALUE , e = Integer.MIN_VALUE , res = s;
        for(int val : bloomDay) {
            s = Math.min(s , val);
            e = Math.max(e , val);
        }
       while(s <= e) {
         int m = s + ( e - s ) / 2;
         int no_of_days = possible(bloomDay , m);
         if(no_of_days < m_days) s = m+1;
         else {
            res = Math.min(res , m);
            e = m-1;
         }
       }
       return (res != Integer.MAX_VALUE) ? res : -1;
    }
    public int possible(int[] arr , int day) {
        int cnt = 0 , res = 0;
        for(int val : arr) {
            if(val > day){
                res += (cnt/f);
                cnt = 0;
            }
            else cnt++;
        }
        res += (cnt/f);
        return res;
    }
}