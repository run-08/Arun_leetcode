class Solution {
    int target;
    public int numMatchingSubseq(String s, String[] words) {
        target = 0;
        HashMap<Character , List<Integer>> indices = new HashMap<>();
        int n = s.length();
        int cnt = 0;
        for(int i = 0;i < n;i++) indices.computeIfAbsent(s.charAt(i) , k -> new ArrayList<>()).add(i);
        for(String word : words) {
            n = word.length();
            if(indices.containsKey(word.charAt(0))) target = indices.get(word.charAt(0)).get(0);
            else continue;
            boolean flag = true;
            for(int i = 1;i < n;i++) {
                 if(!indices.containsKey(word.charAt(i)) || !findIndices(target , indices.get(word.charAt(i)))) {
                    flag = false;
                    break;
                 }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
    public boolean findIndices(int t , List<Integer> indexes) {
        int size = indexes.size();
        int s = 0;
        int e = size-1;
        while( s <= e) {
            int m = s + ( e - s ) / 2;
            int index = indexes.get(m);
            if(index <= t) s = m + 1;
            else e = m - 1;
        }
        if(s >= size) return false;
        target = indexes.get(s);
        return true;
    }
}