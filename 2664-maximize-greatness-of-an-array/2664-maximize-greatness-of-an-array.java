class Solution {
    public int maximizeGreatness(int[] nums) {
      Arrays.sort ( nums );
      int slow = 0 , fast = 0 , numsSize = nums.length;
      while ( slow < numsSize && fast < numsSize ) {
         if ( nums [ slow ] < nums [ fast ] ) slow++;
         fast++;
      }
      return slow;
    }
}