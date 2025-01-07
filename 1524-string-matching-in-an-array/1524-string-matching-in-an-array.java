class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
             boolean flag = false;
             for(String wrd : words) if(wrd.contains(word) && word != wrd) flag = true;
             if(flag) res.add(word);
         }
        return  res;
    }
}