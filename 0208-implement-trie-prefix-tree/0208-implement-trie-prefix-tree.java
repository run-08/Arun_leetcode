class Trie {
    Node  root = new Node();
    
    
    public void insert(String word) {
        if(word == null || word.trim().isEmpty()) return;
        Node current = root;
        for(char c : word.toCharArray()){
            if(c >= 65 && c <= 91) return;
            if(current.children[c-'a'] == null) current.children[c-'a'] = new Node();
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        if(word == null || word.trim().isEmpty()) return false;
        Node current = root;
        for(char c : word.toCharArray()){
            if(c >= 65 && c <= 91) return false;
            if(current.children[c-'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String word) {
        if(word == null || word.trim().isEmpty()) return false;
        Node current = root;
        for(char c : word.toCharArray()){
            if(c >= 65 && c <= 91) return false;
            if(current.children[c-'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return true;
    }
}
class Node {
    Node[] children = new Node[26];
    boolean isWord = false;
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */