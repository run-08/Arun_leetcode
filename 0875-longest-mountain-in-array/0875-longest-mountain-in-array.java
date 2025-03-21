class Solution {
    public int longestMountain(int[] arr) {
        int res = 0 , inc = 1 , dec = 0 , n = arr.length;
        for(int i = 1;i < n;i++) {
            if(arr[i] == arr[i-1]) {
                inc = 1;
                dec = 0;
            }
            else if(arr[i] < arr[i-1]) {
                dec++;
                if(inc > 1) res = Math.max(inc+dec , res);
            }
            else {
                if(dec != 0) {
                    dec = 0;
                    inc = 1;
                }
                inc++;
            }
        }
        return res;
    }
}