class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int[] arr = new int[1001];
        int cnt = n;
        for(int i = 0;i < n;i++) arr[nums1[i][0]] += nums1[i][1];
        n = nums2.length;
        for(int i = 0;i < n;i++){
            if(arr[nums2[i][0]]  == 0) cnt++;
             arr[nums2[i][0]] += nums2[i][1];
        }
        int res[][] = new int[cnt][2];
        int idx = 0;
        for(int i = 0;i < 1001;i++) {
            if(arr[i] == 0) continue;
            res[idx][0] = i;
            res[idx++][1] = arr[i];
        }
        return res;
    }
}