class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n+1];
        for(int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int val = booking[2];
            if(start <= n) arr[start] += val;
            if(end+1 <= n) arr[end+1] -= val; 
        }
        int[] res = new int[n];
        for(int i = 1;i <= n;i++) arr[i] += arr[i-1];
        for(int i = 1;i <= n;i++) res[i-1] = arr[i];
        return res;
    }
}