class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res  = 1,   sum = nums[0], n = nums.length , idx = 0;
        for(int i = 1;i < n;i++) {
            // System.out.print(sum+" "+i+" "+(sum & nums[i])+"\n");
            if((sum & nums[i]) != 0){
                for(;idx < i;idx++){
                    if((sum & nums[i]) == 0) break;
                    sum -= nums[idx]; 
                }
            }
            sum += nums[i];
            res = Math.max((i-idx)+1, res);
        }
        return res;
    }
}