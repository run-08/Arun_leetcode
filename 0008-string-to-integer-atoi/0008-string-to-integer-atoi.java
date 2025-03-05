class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.equals("")) return 0;
        boolean isNegative = (s.charAt(0) == '-') ? true : false;
        if(s.charAt(0) =='+' || s.charAt(0) == '-') s = s.substring(1);
        String res = "";
        int n = s.length();
        boolean init = true;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == '-' || s.charAt(i) == '+') break;
            if(s.charAt(i) == ' ' || (s.charAt(i) >= 97 && s.charAt(i) <= 122) || s.charAt(i) == '-' || s.charAt(i) == '.' ) break;
            else {
                if(s.charAt(i) == '0' && init) continue;
                res += Character.getNumericValue(s.charAt(i));
                init = false;
            }
        }
        int result = 0;
        if(res.length() > 0 && res.length() <= 10){
                long dig = Long.parseLong(res);
                if(isNegative) dig = -dig;
                if(dig >= Integer.MAX_VALUE) result = Integer.MAX_VALUE;
                else if(dig <= Integer.MIN_VALUE) result = Integer.MIN_VALUE;
                else {
                    result = Integer.parseInt(res);
                    if(isNegative) result = -result;
                }
                }
        else {
            if(res.length() > 10) {
                if(!isNegative)result = Integer.MAX_VALUE;
                else result = Integer.MIN_VALUE;
            }
            else result = 0;
        }
        return result;
    }
}