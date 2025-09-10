class Solution {

    public boolean validPalindrome(String s) {

        int sLength = s.length(), startPointer = 0, endPointer = sLength - 1 ;

        while ( startPointer < endPointer ) {

            if ( s.charAt ( startPointer ) != s.charAt ( endPointer ) ) return isPalindrome ( s, startPointer + 1, endPointer ) || isPalindrome ( s, startPointer , endPointer - 1 );

               
            startPointer++;
            endPointer--;

        }

        return true;
        
    }

    private boolean isPalindrome ( String word, int startPointer, int endPointer ) {

        while ( startPointer < endPointer ) if ( word.charAt ( startPointer++ ) != word.charAt ( endPointer-- ) ) return false;

       return true;
    }
}