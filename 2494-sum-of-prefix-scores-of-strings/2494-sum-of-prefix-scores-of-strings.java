class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] Data = new int[words.length];
        Trie object = new Trie();
        for(String temp : words) object.insert(temp);
        for(int i = 0;i < words.length;i++) Data[i] = object.search(words[i]);
        return Data;
    }
}
class TrieNode{
    int val;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
class Trie{
    TrieNode root = null;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(temp.children[c-'a'] == null) temp.children[c-'a'] = new TrieNode();
            temp = temp.children[c-'a'];
            temp.val++;
        }
    }
    public int search(String word){
        int count = 0;
        TrieNode temp = root;
        for(char c : word.toCharArray()){
             count += temp.children[c-'a'].val;
             temp = temp.children[c-'a'];
        }
        return count;
    }
}