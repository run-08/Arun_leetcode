class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        HashMap < String, String > map = new HashMap <> ();
        HashSet < String > uniqueWordList = new HashSet<> ();
        int queriesLength = queries.length;

        for ( String word : wordlist ) {

            if ( !uniqueWordList.add ( word ) ) continue;

            String lowerCaseWord = word.toLowerCase();
            String vowelReplacedWord = vowelReplacer ( lowerCaseWord );

            if ( !map.containsKey ( lowerCaseWord ) ) map.put( lowerCaseWord, word  );
            if ( !map.containsKey ( vowelReplacedWord ) ) map.put( vowelReplacedWord, word  );


        }

        // System.out.print( map );

        for ( int index = 0 ; index < queriesLength ; index++ ) {

             String word = queries [ index ];

              if ( uniqueWordList.contains ( word ) ) continue;

              String lowerCaseWord = word.toLowerCase();
              String vowelReplacedWord = vowelReplacer ( lowerCaseWord );

              if ( map.containsKey ( lowerCaseWord ) ) queries [ index ] = map.get ( lowerCaseWord );

              else if ( map.containsKey ( vowelReplacedWord ) ) queries [ index ] = map.get ( vowelReplacedWord ); 

              else queries [ index ] = "";

        }

        return queries;

    }

    private String vowelReplacer ( String word ) {

        StringBuilder newWord = new StringBuilder();

         for ( char character : word.toCharArray() ) newWord.append (  ( "aeiouAEIOU".indexOf( character ) != -1 ) ? "-" : character );

         return newWord.toString();

    }
}