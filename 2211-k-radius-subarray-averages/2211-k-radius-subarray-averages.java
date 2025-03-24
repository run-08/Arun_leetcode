class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length  , idx = 0;
        int[] arr = new int[n];
        long p_sum = 0;
        Arrays.fill(arr ,-1);
        if(k >= n || k > (n-k)) return arr;
        while(idx < k) p_sum += nums[idx++];
        for(int i = 0;i < k;i++) p_sum += nums[idx+i];
        for(;idx < n && (idx+k) < n;idx++) {
            p_sum += nums[idx+k];
            arr[idx] =(int)( p_sum / ((k*2)+1));
            p_sum -= nums[idx-k];
        }
        return arr;
    }
}