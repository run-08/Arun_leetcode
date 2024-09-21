class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
         for(String Data : patterns) if(word.contains(Data)) count++;
         return count;
    }
}