class Solution {
    public int possibleStringCount(String word) {
        int possibleOriginalString = 1 , wordLength = word.length();
        for( int i = 0 ; i < wordLength ;  ) {
            char IthCharacter = word.charAt(i);
            int IthCharacterMatchedCount = 0;
            while( i < wordLength  && word.charAt(i) == IthCharacter ) {
                IthCharacterMatchedCount++;
                i++;
            }
            possibleOriginalString += IthCharacterMatchedCount - 1;
        } 
        return possibleOriginalString ; 
    }
}