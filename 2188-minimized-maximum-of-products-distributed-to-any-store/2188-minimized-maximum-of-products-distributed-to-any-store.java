class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int s = 1 , e = 0;
        for(int val : quantities) e = Math.max(val , e);
        while(s <= e) {
            int m = s + ( e - s ) / 2;
            int cnt = 0;
            for(int val : quantities) cnt += ((val % m == 0) ? val / m : ( val / m )+1);
            if(cnt <= n) e = m - 1;
            else s = m + 1;
        }
        return s;
    }
}