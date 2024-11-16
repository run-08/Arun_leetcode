class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for(int val :  nums) if(val % 3 != 0) cnt++;
        return cnt;
    }
}