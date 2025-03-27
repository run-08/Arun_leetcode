class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length() , cnt = 0 , max = 0;
        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
            if(isVowel(c))cnt++;
            if(i+1 < k) continue;
            max = Math.max(max , cnt);
            if(isVowel(s.charAt((i+1)-k))) cnt--;
        }
        return max;
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}