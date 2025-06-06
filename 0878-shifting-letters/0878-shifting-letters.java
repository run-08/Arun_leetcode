class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder data = new StringBuilder();
        int n = s.length();
        for(int i  = 0;i < n;i++) shifts[i] %= 26;
        for(int i = n-1;i >= 0;i--){
            if(i > 0) shifts[i-1] += shifts[i];
            shifts[i] += s.charAt(i)-97;
            shifts[i] %= 26;
            data.append((char)(shifts[i]+97));
        }
        return data.reverse().toString();
    }
}