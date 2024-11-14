class Solution {
    public int maximum69Number (int num) {
        String data = String.valueOf(num);
        String res = "";
        int idx = 0;
        for(char c : data.toCharArray()){
            if(c == '6') {
                res += "9";
                res += data.substring(idx+1,data.length());
                break;
            }
             res += "9";
             idx++;
        }
        return Integer.parseInt(res);
    }
}