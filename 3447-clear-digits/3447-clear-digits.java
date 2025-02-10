class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        String res = "";
        for(int i = 0;i < n;i++) res = (s.charAt(i) >= 45 && s.charAt(i) <= 57 ) ? res.substring(0,res.length()-1) : res + s.charAt(i);
        return res;
    }
}