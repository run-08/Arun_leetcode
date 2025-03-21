class Solution {
    public int splitArray(int[] weights, int days) {
       int e = 0 ,s = weights[0] , res = Integer.MAX_VALUE;
        for(int val : weights) {
            e += val;
            s = Math.max(val , s);
        }
        while(s <= e) {
            int m = (s+e)/2;
            int cnt = 0;
            int sum = 0;
            for(int ele : weights) {
                sum += ele;
                if(sum >= m) {
                  if(sum > m)sum = ele;
                  else sum = 0;
                  cnt++;
                }
            }
            if(sum > 0) cnt++;
            if(cnt > days) s = m+1;
            else e = m-1;
        }
        return s;
    }
}