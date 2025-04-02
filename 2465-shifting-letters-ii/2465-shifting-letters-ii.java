class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] p_sum = new int[n];
        for(int[] arr : shifts) {
            int start = arr[0];
            int end = arr[1];
            int value = (( arr[2] & 1 ) == 0 ) ? -1 : 1;
            p_sum[start] += value;
            if(value == -1) value = 1;
            else value = -1;
            if(end+1 < n) p_sum[end+1] += value;
        }
        int sum = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < n;i++) {
            sum += p_sum[i];
            boolean isNegative = sum < 0;
            sum = Math.abs(sum);
            if(sum == 0) {
                res.append(s.charAt(i));
                continue;
            }
            int val = sum % 26;
            int ascii_val = s.charAt(i);
            if(!isNegative) {
                  ascii_val += val;
                 if(ascii_val > 122) {
                    ascii_val -= 122;
                    ascii_val += 96;
                 }
            }
            else {
                sum = -sum;
                ascii_val -= val;
                if(ascii_val < 97) {
                    ascii_val = 97 - ascii_val;
                    ascii_val = 123 - ascii_val;
                }
            }
            res.append((char)(ascii_val));
        }
        return res.toString();
    }
}