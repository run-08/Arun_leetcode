class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int left = 0;
        int equal = 0;
        for(int val : nums) {
            if(val < pivot)left++;
            if(val == pivot)equal++;
            }
          int e = left;
          int l = 0;
          int r = left+equal;
         for(int val : nums){
             if(val < pivot) arr[l++] = val;
             if(val == pivot ) arr[e++] = val;
             if(val > pivot) arr[r++] = val;
             }
        return arr;
    }
}