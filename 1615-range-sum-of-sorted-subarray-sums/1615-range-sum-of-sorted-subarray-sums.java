class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int arr[] = new int[(n*(n+1)/2)];
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            int sum = nums[i];
            arr[index++] = sum;
            for(int j = i+1;j < nums.length;j++){
                sum += nums[j];
                arr[index++] = sum;
           }
       }
        Arrays.sort(arr);
        long sum = 0;
        for(int i = left-1;i < right;i++) sum = (sum + arr[i]) % 1000000007;
        return (int)sum;
    }
}