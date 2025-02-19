class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0;i < n;i++){
            int len = sb.length();
            if(len == 0 || s.charAt(i) != sb.charAt(len-1)) sb.append(s.charAt(i));
            else sb.deleteCharAt(len-1);
        }
        return sb.toString();
    }
}