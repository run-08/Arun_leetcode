class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] arr = new int[26];
        for(int i = 0;i < 26;i++) arr[i] = i+1;
        int idx = 0;
        for(char c : chars.toCharArray()) arr[c-97] = vals[idx++];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(char c : s.toCharArray()){
            cur += arr[c-97];
            if(cur < 0) cur = 0;
            max = Math.max(cur , max);
        }
        return max;
    }
}