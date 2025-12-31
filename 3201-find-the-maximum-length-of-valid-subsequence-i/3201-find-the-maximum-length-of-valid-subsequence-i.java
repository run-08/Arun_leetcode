class Solution {
    public int maximumLength(int[] nums) {
        // only 4 choices -> Even + Even
        // Odd + Odd...
        // Even Odd...
        // Odd + Even...
        int evenCount = 0,oddCount = 0,n=nums.length,max=0,oddEven = 0,evenOdd=0;
        boolean flag = false;
        for(int i=0;i<n;i++) {
            if(nums[i] % 2 == 0) {
                evenCount++;
                if(!flag) {
                    flag = true;
                    evenOdd++;
                }
            }
            else {
                oddCount++;
                if(flag) {
                    flag = false;
                    evenOdd ++;
                }
            }
        }
        max = Math.max(oddCount,Math.max(evenCount,evenOdd));
        flag = false;
        for(int i=0;i<n;i++){
            if(nums[i] %  2 == 1){
                if(!flag){
                    flag = true;
                    oddEven += 1;
                }
            }
            else{
                  if(flag){
                    flag = false;
                    oddEven += 1;
                  }
            }
        }
        return Math.max(max,oddEven);
        
    }
}