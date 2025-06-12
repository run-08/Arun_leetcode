class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<WordLadder> q = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        q.offer(new WordLadder(beginWord , 1));
        while(!q.isEmpty()){
             WordLadder obj = q.poll();
             String word = obj.word;
             if(word.equals(endWord)) return (obj.transformation);
             int size = word.length();
             for(int i = 0;i < size;i++) {
                String begin = word.substring(0,i) , end = word.substring(i+1 , size);
                for(char c = 'a'; c <= 'z';c++) {
                    String nextWord = begin+c+end;
                    if(wordSet.contains(nextWord)){
                        q.offer(new WordLadder(nextWord , obj.transformation+1));
                        wordSet.remove(nextWord);
                    }
                }
             }
        }
        return 0;
    }
}
class WordLadder{
    String word;
    int transformation;
    WordLadder(String word , int transformation){
        this.word = word;
        this.transformation = transformation;
    }
}