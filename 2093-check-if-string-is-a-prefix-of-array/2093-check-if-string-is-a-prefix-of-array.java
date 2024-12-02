class Solution {
    public boolean isPrefixString(String s, String[] words) {
         String make_sentence = "";
         for(String word : words){
            make_sentence += word;
            if(make_sentence.equals(s)) return true;
         }
         return false;
    }
}