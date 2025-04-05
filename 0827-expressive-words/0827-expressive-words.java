class Solution {
    public int expressiveWords(String s, String[] words) {
        int cnt = 0  , n = s.length();
        for(String query : words) {
            int p1 = 0 , m = query.length();
            if(m > n) continue;
            boolean isStretchy = true;
            for(int i  = 0;i < n && isStretchy;i++) {
                int s_freq = 1 , q_freq = 0;
                char c = s.charAt(i);
                for(;i+1 < n;i++) {
                    if(s.charAt(i+1) != c) break;
                    else s_freq++;
                }
                for(;p1 < m;p1++) {
                    if(query.charAt(p1) ==  c ) q_freq++;
                    else break;
                }
                if(q_freq != 0 && q_freq <= s_freq &&  ((s_freq-q_freq == 0) || (s_freq > 2))) continue;
                else isStretchy = false;
            }
            if(isStretchy && p1 == m) cnt++;
        }
        return cnt;
    }
}