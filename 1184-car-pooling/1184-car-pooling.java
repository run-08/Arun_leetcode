class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for(int[] arr : trips) max = Math.max(arr[2] , max);
        int[] arr = new int[max];
        for(int[] trip : trips) {
         int passanger = trip[0] , from = trip[1] , to = trip[2];
         if(from >= 0 && from < max) arr[from] += passanger;
         if(to < max && to > 0) arr[to] -= passanger;
        }
        for(int i = 1;i < max;i++) arr[i] += arr[i-1];
        for(int i = 0;i < max;i++) if(arr[i] > capacity) return false;
        return true;
    }
}