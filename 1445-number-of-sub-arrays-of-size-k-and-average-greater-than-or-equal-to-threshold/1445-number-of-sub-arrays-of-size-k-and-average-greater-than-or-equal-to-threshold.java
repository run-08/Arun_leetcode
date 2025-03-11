class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int cur = 0;
        int res = 0;
        for(int i = 0;i < k;i++) cur +=arr[i];
        if((cur / k) >= threshold) res++;
        for(int i = k;i < n;i++){
            cur -= arr[i-k];
            cur += arr[i];
            if((cur / k) >= threshold) res++;
        }
        return res;
    }
}