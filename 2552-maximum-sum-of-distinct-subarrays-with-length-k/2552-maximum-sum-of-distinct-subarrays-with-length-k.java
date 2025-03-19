class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        int numNonOne = 0;
        long sum = 0;
        long totalSum = 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            sum += num;
            if (count[num] == 1) {
                numNonOne++;
            }
            //System.out.println("num " + num + ", sum" + sum + ", n1Flag " + numNonOne);
            count[num]++;
            //System.out.println(Arrays.toString(count));
        }

        if (numNonOne == 0 && sum > totalSum) {
            totalSum = sum;
        }

        int n = nums.length;
        for (int i = k; i < n; i++) {
            int num = nums[i];
            int prevNum = nums[i - k];
            sum += num;
            sum -= prevNum;
            //System.out.println("prev Num" + prevNum + "num " + num + ", sum" + sum + ", n1Flag " + numNonOne);
            if (count[prevNum] == 2) {
                numNonOne--;
            }
            count[prevNum]--;
            if (count[num] == 1) {
                numNonOne++;
            }
            count[num]++;
            //System.out.println(Arrays.toString(count));
            if (numNonOne == 0 && sum > totalSum) {
                totalSum = sum;
            }
        }

        return totalSum; 
    }
}