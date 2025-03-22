class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0 , n = s.length() , len = p.length()  ,start = 0 , end = removable.length-1;
        if(n < len) return 0;
        while(start <= end) {
            int mid = start + ( end - start ) / 2;
            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0;i <= mid;i++) hs.add(removable[i]);
            int cnt = 0;
            int idx_s = 0;
            int idx_p = 0;
            while(idx_s < n) {
                if(cnt >= len) break;
                if(hs.contains(idx_s)) {
                    idx_s++;
                    continue;
                }
                if(s.charAt(idx_s) == p.charAt(idx_p)) {
                    idx_p++;
                    cnt++;
                }
                idx_s++;
            }
            if(cnt >= len) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}