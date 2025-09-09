class Solution {

    public int maxRepeating(String sequence, String word) {
        
        int sequenceLength = sequence.length(), wordLength = word.length(), index = 0, maxRepeatingLength = 0;

        while ( index < sequenceLength ) {

            if ( sequence.charAt ( index ) == word.charAt ( 0 ) ) {

                   int wordPointer = 0, tempIndex = index, count = 0;

                   while ( index < sequenceLength && sequence.charAt ( index ) == word.charAt ( wordPointer ) ) {

                        if ( wordPointer == wordLength - 1 ) {

                              wordPointer = -1;
                              count++;

                        }

                        index++;
                        wordPointer++;

                   }

                   maxRepeatingLength = Math.max ( maxRepeatingLength, count );
                   index = tempIndex;

            } 

            index++;

        }

        return maxRepeatingLength; 
    }
}