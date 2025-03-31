class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0 , n = s.length();
        boolean[] arr = new boolean[26];
        for(int i = 0;i < n;i++) arr[s.charAt(i)-65] = true;
        for(char c = 'A'; c <= 'Z';c++) {
            if(!arr[c-65]) continue;
            Deque<Integer> dq = new LinkedList<>();
            int cnt = 0 , K = k , idx = 0;
            for(int i = 0;i < n;i++) {
                if(s.charAt(i) == c) cnt++;
                else {
                    dq.add(i);
                    if(K == 0) {
                        idx = dq.poll();
                        cnt = (i-idx);
                    }
                    else{
                         K--;
                         cnt++;
                    }
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}