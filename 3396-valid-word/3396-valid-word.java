class Solution {
    public boolean isValid(String word) {
        boolean isVowel = false , isLetter = false;
        int  wordLength = 0;
        for ( char character : word.toCharArray() ) {
            wordLength++;
            if ( isVowel ( character ) )  isVowel =  true;
            else if ( ( character >= 97 && character <= 122 ) || ( character >= 65 && character <= 90) ) isLetter =  true;
            else if ( character >= '0' && character <= '9' ) continue;
            else return false;
        }
        return isVowel && isLetter && wordLength >= 3 ;
    }
    private boolean isVowel ( char character ) {
         return ( character == 'A' || character == 'a' || character == 'E' || character == 'e' || character == 'I' || character == 'i' || character == 'O' || character == 'o' || character == 'U' || character == 'u' );
    }
}