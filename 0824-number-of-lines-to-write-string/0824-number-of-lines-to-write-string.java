class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int cnt = 0;
        int sum = 0;
        for(char c : s.toCharArray()){
             sum += widths[c - 97];
             if(sum >= 100){
                sum = (sum % 100 == 0) ? 0 :  widths[c - 97];
                cnt += 1;
             }
        }
        return new int[]{(sum != 0) ? cnt+1 : cnt , (sum == 0) ? 100 : sum};
    }
}