class Solution {
    public int findMin(int[] nums) {
        int min = 5000;
       for(int val : nums) if(min > val) min = val;
       return min;
}
}