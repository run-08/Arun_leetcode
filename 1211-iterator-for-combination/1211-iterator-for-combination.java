class CombinationIterator {
    List<String> combination;
    public CombinationIterator(String characters, int combinationLength) {
        combination = new ArrayList<>();
        GenerateCombinationsWord(characters , combinationLength , "",0);
    }
    public String next() {
       String next = combination.get(0);
       combination.remove(0);
       return next;   
    }
    
    public boolean hasNext() {
        return combination.size() != 0;
    }
    private void GenerateCombinationsWord(String s , int n , String cur , int idx){
        if(cur.length() == n) {
        combination.add(cur);
            return;
        }
        if(idx >= s.length()) return;
        GenerateCombinationsWord(s , n , cur+s.charAt(idx) , idx+1);
        GenerateCombinationsWord(s , n , cur , idx+1);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */