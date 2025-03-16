class Solution {
    public int minKBitFlips(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int res = 0 , n = nums.length , cnt = 0 ;
        for(int i = 0;i < n;i++) {
            if(hs.contains(i)) cnt-= 1;
            nums[i] ^= ((cnt & 1) == 0) ? 0 : 1; 
            // System.out.print(nums[i]+" "+i+"\n");
            if(nums[i] == 1) continue;
            if((i+k) > n) return -1;
            else {
                res += 1;
                cnt += 1;
                hs.add(i+k);
            }
        }
        return res;
    }
}