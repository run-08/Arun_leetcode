class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentence_array = sentence.split(" ");
        for(int i = 0;i < sentence_array.length ; i++) if(sentence_array[i].indexOf(searchWord) == 0) return i+1;
        return -1;
    }
}