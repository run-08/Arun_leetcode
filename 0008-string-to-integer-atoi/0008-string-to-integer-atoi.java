
import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) return 0;

        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        String res = "";

        if (sb.charAt(0) == '-' || sb.charAt(0) == '+') {
            i = 1;
            if (sb.charAt(0) == '-') res += "-";
        }

        for (i = i; i < sb.length(); i++) {
            if (!Character.isDigit(sb.charAt(i))) break;
            res += sb.charAt(i);
        }

        if (res.isEmpty() || res.equals("-")) return 0;

        BigInteger bigInt = new BigInteger(res);
        BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger intMin = BigInteger.valueOf(Integer.MIN_VALUE);

        if (bigInt.compareTo(intMax) > 0) return Integer.MAX_VALUE;
        if (bigInt.compareTo(intMin) < 0) return Integer.MIN_VALUE;

        return bigInt.intValue();
    }
}
