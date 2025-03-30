class Solution {
    public long validSubstringCount(String s1, String s2) {
        int cnt = 0 , l1 = s1.length() , l2 = s2.length() , unique = 0;
        int[] w1 = new int[26];int[] w2 = new int[26];
        long res = 0;
        HashMap<Character , List<Integer>> hm = new HashMap<>();
        for(int i = 0;i < l2;i++) {
            char c = s2.charAt(i);
            w2[c-97]++;
            if(w2[c-97] < 2) unique++; 
        }
        for(int i = 0;i < l1;i++) {
            char c = s1.charAt(i);
            hm.computeIfAbsent(c , k ->  new ArrayList<>()).add(i);
            w1[c-97]++;
            if(w1[c-97] == w2[c-97]) cnt++;
            if(hm.get(c).size() > w2[c-97]) hm.get(c).remove(0);
            if(cnt != unique) continue;
            int min_idx = 1000000;
            for(int j = 0;j < 26;j++) {
                if(w2[j] == 0) continue;
                List<Integer> ls = hm.get((char)(j+97));
                min_idx = Math.min(ls.get(0) , min_idx);
            }
            res += (min_idx)+1;
        }
        return res;
    }
}