class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String , Integer> hm = new HashMap<>();
        for(String word : words) hm.put(word , hm.getOrDefault(word,0)+1);
        int res = 0;
        boolean isMid = false;
        for(String word : words) {
            if(!hm.containsKey(word)) continue;
            if(word.charAt(0) == word.charAt(1)) {
               int one = hm.get(word);
               if((one & 1) == 1) if(isMid) one -= 1;
               else isMid = true;
               res += one * 2;
               hm.remove(word);
               continue; 
            }
            String word_rev = word.charAt(1)+""+word.charAt(0);
            if(!hm.containsKey(word_rev)) continue;
            int one = hm.get(word) , two = hm.get(word_rev);
            res += Math.min(one , two) * 4;
            hm.remove(word);
            hm.remove(word_rev);
        }
        return res;
    }
}