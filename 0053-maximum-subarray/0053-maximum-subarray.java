class Solution {
    public int maxSubArray(int[] nums) {
        int currentNum = nums[0];
        int maximumNum = currentNum;
        for(int i = 1;i < nums.length;i++) {
            currentNum += nums[i];
            if(currentNum < nums[i]) currentNum = nums[i];
            maximumNum = (currentNum > maximumNum) ? currentNum : maximumNum;      // O( N )
        } 
        return maximumNum;
        // int max = arr[0];
        // for(int i = 0;i < arr.length;i++){
        //     int currentElement = arr[i];
        //     if(currentElement > max) max = currentElement;
        //     for(int j = i+1;j < arr.length;j++) {
        //             currentElement += arr[j];
        //             if(max < currentElement) max= currentElement;   // O ( N ^ 2 )
        //     }
        // }
        // return max;
    }
}