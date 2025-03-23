class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int[] freq = new int[26];
            int left = 0, right = 0, unique = 0, countAtLeastK = 0;

            while (right < n) {
                if (unique <= uniqueTarget) {
                    int index = s.charAt(right) - 'a';
                    if (freq[index] == 0) unique++;
                    freq[index]++;
                    if (freq[index] == k) countAtLeastK++;
                    right++;
                } else {
                    int index = s.charAt(left) - 'a';
                    if (freq[index] == k) countAtLeastK--;
                    freq[index]--;
                    if (freq[index] == 0) unique--;
                    left++;
                }

                if (unique == uniqueTarget && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}
