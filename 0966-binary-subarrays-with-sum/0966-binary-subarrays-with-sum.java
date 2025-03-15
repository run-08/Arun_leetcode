class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length , cur = 0 ,  idx = -1 , res = 0 , sum = 0;
        if( goal == 0) return bin(idx ,  res , goal , n , nums);
        for(int i = 0;i < n;i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                System.out.print(cur+" "+i+"\n");
                if(sum == goal) res += cur+1;
                else if(idx == -1) cur++;
            }
            if(nums[i] == 1) {
                if(idx == -1) {
                   idx = i;
                   if(sum == goal) res = cur+1;
                }
                else if(sum > goal) {
                    cur = 0;
                    idx += 1;
                    sum -= 1;
                    for(;idx <= i;idx++) {
                        if(nums[idx] == 0)cur++;
                        else break;
                    }
                    res += cur+1;
                }
                else if(sum == goal) res += cur+1;
            }
        }
        return res;
    }
    public int bin(int idx , int res ,int goal , int n , int[] nums){
        int sum = 0;
            for(int i = 0;i < n;i++) {
                if(nums[i] != goal)  idx = -1;
                else if(nums[i] == goal && idx == -1) {
                    res += 1;
                    idx = i;
                } 
                else  if(nums[i] == goal && idx != -1) res += (i-idx)+1;
            }
           return res;
    }
}