class Solution {
    public int minimumLength(String s) {
         int[] freq = new int[26];
         int n = s.length();
         for(int i = 0;i < n;i++) freq[s.charAt(i) - 97] += 1;
         int dec = 0;
         for(int val : freq) if(val != 0) dec += (val % 2 != 0) ? val / 2 : (val / 2) -1 ;
         return n - dec*2;
    }
}