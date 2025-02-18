class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i = 0;i < n;i++){
            int len = res.length();
            if(len == 0) res.append(s.charAt(i));
            else {
                char c = res.charAt(len-1);
                if(Math.abs(s.charAt(i)- c) == 32) res.deleteCharAt(len-1);
                else res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}