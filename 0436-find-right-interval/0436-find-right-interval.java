class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][2];
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i = 0;i < n;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            hm.put(arr[i][0] , i);
        }
        int[] res = new int[n];
        int idx = 0;
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0] , b[0]));
        for(int i = 0;i < n;i++) {
            int t = intervals[i][1] , s = 0 , e = n - 1;
            while(s <= e) {
                int m = s + ( e - s ) / 2;
                if(arr[m][0] == t) {
                    s = m;
                    break;
                }
                else if(arr[m][0] < t) s = m + 1;
                else e = m - 1;
            }
            if(s >= n) res[idx++] = -1;
            else res[idx++] = hm.get(arr[s][0]);
        }
        return res;
    }
}