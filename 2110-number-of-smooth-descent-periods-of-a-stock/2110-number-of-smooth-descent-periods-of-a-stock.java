class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = n;
        for(int i=1;i<n;i++){
            long count = 1;
            while(i< n && prices[i-1]-prices[i++] == 1) count++;
            i -= 1;
            res += (count*(count-1))/2;
        }
        return res;
    }
}