class Solution {
    public String smallestNumber(String s) {
        String Data = "";
        int cnt = 0;
        int n = s.length();
        for(int i = 0;i <= n;i++) {
            if(i == n) {
                cnt++;
                Data += String.valueOf(cnt);
                break;
            }
            if(s.charAt(i) == 'I'){
                cnt++;
                Data += String.valueOf(cnt);
            }
            else {
                int freq = 0;
                for(;i <= n;i++){
                    cnt++;
                    freq++;
                    if(i == n || s.charAt(i) == 'I')break;
                }
                for(int j = cnt;freq > 0;j--) {
                    Data += String.valueOf(j);
                    freq--;
                }
            }
        }
        return Data;
    }
}