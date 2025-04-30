class Solution {
    int[] limit = new int[26];
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        List<String> hs = new ArrayList<>();
        for(char c : letters) limit[c-97]++;
        int[] limits = new int[26];
        dfs(limits , hs , "" , 0 , words);
        int max = 0;
        for(String word : hs){
            int cur = 0;
            for(char c : word.toCharArray()) cur += score[c-97]; 
            max = Math.max(cur , max);
        }
        return max;
    }
    public void dfs(int[] limits , List<String> hs , String cur , int idx , String[] words){
         if(idx == words.length){
            hs.add(cur);
            return;
         }
         String word = words[idx];
         int limit1[] = new int[26];int[] limit2 = new int[26];
         for(int i = 0;i < 26;i++) {
            limit1[i] = limits[i];
            limit2[i] = limits[i]; 
         }
         boolean isOkay = true;
         for(char c : word.toCharArray()) {
            if(limit1[c-97]+1 > limit[c-97]) isOkay = false;
            else limit1[c-97] += 1;
            if(!isOkay) break;
         }
         dfs(limit2 , hs , cur , idx+1 , words);
         if(isOkay) dfs(limit1 , hs , cur+word , idx+1 , words);
         else hs.add(cur);
    }
}