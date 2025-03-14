class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length , idx = 0 , cnt = 1;
        int[] res = new int[(n-k)+1];
        for(int i = 1;i < k;i++) {
            if(nums[i] != nums[i-1]+1) cnt = 1;
            else cnt++;
        }
        if(cnt == k) res[idx++] = nums[k-1];
        else res[idx++] = -1;

        for(int i = k;i < n;i++) {
            if(cnt == k)cnt -= 1;
            if(nums[i] != nums[i-1]+1) cnt = 1;
            else cnt++;
            if(cnt == k) res[idx++] = nums[i];
            else res[idx++] = -1;
        }
        return res;
    }
}