class Solution {
    public int minMaxDifference(int num) {
        if(num < 10) return 9;
        int needToReplace = String.valueOf(num).charAt(0) - '0';
        String number = String.valueOf(num);
        int n = number.length();
        if(needToReplace == 9) {
            for(int i = 1;i < n;i++) {
                int ele = number.charAt(i) - '0';
                if( ele != 9) {
                    needToReplace = ele;
                    break;
                }
            }
        } 
        String largeNumber = "";
        for(int i = 0;i < n;i++) {
            int ele = number.charAt(i) - '0';
            if(ele == needToReplace) largeNumber += "9";
            else largeNumber += number.charAt(i);
        }
        int small = Integer.MAX_VALUE;
        for(int i = 0;i <= 9;i++) {
            String temp = "";
            for(int j = 0;j < n;j++) {
                int ele = number.charAt(j) - '0';
                if(ele == i) temp += "0";
                else temp += number.charAt(j);
            }
            int sn = Integer.parseInt(temp);
            small = Math.min(small , sn);
        }
        return Integer.parseInt(largeNumber) - small;
    }
}