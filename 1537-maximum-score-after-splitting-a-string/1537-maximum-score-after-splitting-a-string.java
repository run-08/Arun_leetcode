class Solution {
    public int maxScore(String s) {
        int one = 0;
        int max = 0;
        for(char val : s.toCharArray())  if(val == '1') one++;
        StringBuffer sb = new StringBuffer(s);
        int zero = 0;
        while(sb.length() > 1){
            if(sb.charAt(0) == '0')  zero++;
            else one--;
            sb.delete(0,1);
            max = Math.max(max,zero+one);
        }
        return max;
    }
}