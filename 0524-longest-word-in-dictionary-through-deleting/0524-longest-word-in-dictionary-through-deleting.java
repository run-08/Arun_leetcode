class Solution {
     HashMap<Character , List<Integer>> hm;
    public String findLongestWord(String s, List<String> dictionary) {
        hm = new HashMap<>();
        int n = s.length() , max = 0;
        List<String> ls= new ArrayList<>();
        for(int i = 0;i < n;i++) hm.computeIfAbsent(s.charAt(i) , k -> new ArrayList<>()).add(i);
        for(String Data : dictionary) {
            if(findTarget(Data)) {
                int len = Data.length();
                if(len > max) {
                    ls.clear();
                    max = len;
                    ls.add(Data);
                }
                else if(len == max) ls.add(Data);
            }
        }
        Collections.sort(ls);
        return (ls.size() > 0 ) ? ls.get(0) : "";
    }
    public boolean findTarget(String str ) {
        if(!hm.containsKey(str.charAt(0))) return false;
         int t = hm.get(str.charAt(0)).get(0) , n = str.length();
        for(int i = 1;i < n;i++) {
            int s = 0;
            if(!hm.containsKey(str.charAt(i))) return false;
            List<Integer> ls = hm.get(str.charAt(i));
            int size = ls.size();
            int e = size-1;
            while(s <= e) {
                int m = s + ( e  - s )/ 2;
                int val = ls.get(m);

                if(val <= t) s = m + 1;
                else e = m - 1;
            }
            if(s < 0 || s >= size || ls.get(s) <= t) return false;
            else t = ls.get(s);
        }
        return true;
    }
}