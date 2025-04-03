class Solution {
    public int sumOfBeauties(int[] nums) {
       boolean isSorted = true;
       int n = nums.length;
       int[] pre = new int[n] ; int[] suf = new int[n];
       pre[0] = nums[0];
       for(int i = 1;i < n;i++) {
           pre[i] = Math.max(pre[i-1] , nums[i]);
       }
       suf[n-1] = nums[n-1];
       for(int i = n-2;i >= 0;i--) {
         suf[i] = Math.min(suf[i+1] , nums[i]);
       }
    //    System.out.print(Arrays.toString(pre));
       int cnt = 0;
       for(int i = 1;i < n-1;i++) {
          if(nums[i] < nums[i+1] && nums[i] > nums[i-1]) {
            if(pre[i-1] < nums[i] && suf[i+1] > nums[i]) cnt +=2;
            else cnt++;
          }
       }
       return cnt;
    }
}