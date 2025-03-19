class Solution {
    public int numberOfSubstrings(String s, int k) {
        HashMap<Character , List<Integer>> hm = new HashMap<>();
        boolean[] freq = new boolean[26];
        int res = 0 , max = 0 , n = s.length();
        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
            int idx = c-97;
            if(hm.containsKey(c)) hm.get(c).add(i);
            else {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                hm.put(c , new ArrayList<>(ls));
            }
            if(freq[idx]) {
                hm.get(c).remove(0);
                max = Math.max(hm.get(c).get(0)+1 , max);
            }
            else {
                int size = hm.get(c).size();
                if(size == k) {
                   freq[idx] = true;
                   max = Math.max(hm.get(c).get(0)+1 , max);
                }
            }
            res += max;
        }
        return res;
    }
}