class Solution {
    public char kthCharacter(int k) {
        return compute("a",k);
    }
    public char compute(String word , int k ){
        if(k <= word.length()) return word.charAt(k-1);
        else {
            String temp = word;
            for(char c : temp.toCharArray()) word += String.valueOf((char)(c+1));
            return compute(word , k);
        }
    }
}