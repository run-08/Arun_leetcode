class Solution {
    public int minimumIndex(List<Integer> nums) {
        int max = 0 , n = nums.size() , cnt = 0 , high = 0;
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i = 0;i < n;i++) {
            freq.put(nums.get(i)  , freq.getOrDefault(nums.get(i) , 0)+1);
            if(freq.get(nums.get(i)) > max) {
                max = freq.get(nums.get(i));
                high = nums.get(i);
            }
        }
        int idx = 0;
        for(;idx < n ;idx++) {
            if((cnt > (idx-cnt))) break;
            if(nums.get(idx) == high) cnt++; 
        }
        cnt = 0;
        for(int i = idx;i < n;i++) if(high == nums.get(i)) cnt++;
        int target = n-idx;
        if(target-cnt >= cnt) return -1;
        return idx-1;
    }
}