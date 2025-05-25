class Solution {
    public int longestPalindrome(String[] words) {
        int res = 0;
        HashMap<String , Integer> hm = new HashMap<>();
        for(String word : words) hm.put(word , hm.getOrDefault(word,0)+1);
        boolean isPair = false;
        for(String word : words){
            if(!hm.containsKey(word)) continue;
            if(word.charAt(0) == word.charAt(1) ) {
                int freq = hm.get(word);
                if(freq == 1 ) {
                    if(isPair) continue;
                    res += 2;
                    isPair = true;
                }
                else {
                    if(freq % 2 == 0) res += freq * 2;
                    else {
                        res += ( freq - 1) * 2;
                        if(!isPair) {
                            isPair = true;
                            res += 2;
                        }
                    }
                }
                hm.remove(word);
            }
            String rev = word.charAt(1)+""+word.charAt(0);
            if(!hm.containsKey(rev)) {
                hm.remove(word);
                continue;
            }
            int min = Math.min(hm.get(word)  , hm.get(rev));
            hm.remove(word);
            hm.remove(rev);
            res += min * 4;
        }
        return res;
    }
}