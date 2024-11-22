class Solution {
    public String removeTrailingZeros(String num) {
        int idx = num.length()-1;
        for(int i = idx ;i >= 0;i--) {
            if(num.charAt(i) == '0') idx--;
            else break;
        }
        return num.substring(0,idx+1);
    }
}