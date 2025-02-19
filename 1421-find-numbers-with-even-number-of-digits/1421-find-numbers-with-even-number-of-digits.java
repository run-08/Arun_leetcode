class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int val : nums) if( (String.valueOf(val).length() & 1) == 0) cnt++;
        return cnt;
    }
}