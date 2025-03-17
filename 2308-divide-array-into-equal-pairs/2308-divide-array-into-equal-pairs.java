class Solution {
    public boolean divideArray(int[] nums) {
       int[] arr = new int[501];
       for(int val : nums) arr[val]++;
       for(int val : arr) if((val & 1) == 1) return false;
       return true;
    }
}