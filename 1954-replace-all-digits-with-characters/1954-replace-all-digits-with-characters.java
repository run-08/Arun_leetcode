class Solution {
    public String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < s.length();i++) sb.append( (i % 2 == 0) ? String.valueOf(s.charAt(i)) :  String.valueOf((char)(s.charAt(i-1)+Character.getNumericValue(s.charAt(i)))));
        return sb.toString();
    }
}