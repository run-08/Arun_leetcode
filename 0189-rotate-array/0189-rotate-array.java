class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int pos_find = nums.length - k;
        HashMap hm = new HashMap();
        int cnt = 0;
        for(int i = pos_find;i < nums.length;i++){
            hm.put(cnt++,nums[i]);
        }
        for(int i = 0;i < pos_find;i++){
            hm.put(cnt++,nums[i]);
        }
        for(int i = 0;i < nums.length;i++){
            nums[i] = (int)hm.get(i);
        }
    }
}