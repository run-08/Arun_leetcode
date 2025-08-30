class Solution {

    public String minWindow(String s, String t) {
        
    int sLength = s.length() , tLength = t.length() , startPointer = Integer.MAX_VALUE , endPointer = 0 , currentLength = 0;

    HashMap < Character , Deque < Integer >  > map = new HashMap <> ();
    
    PriorityQueue < Integer > pq = new PriorityQueue <> (); 

    int [] freq = new int [ 123 ];

    for ( char c : t.toCharArray() ) {
        
        freq [ c ]++;
        map.put( c, new ArrayDeque <> () );

    }

    for ( int index = 0 ; index < sLength ; index++ ) {

       char c = s.charAt ( index );

       if ( freq [ c ] == 0 ) continue;

       if ( freq [ c ] != -1  ) {

        freq [ c ]--;

        if ( freq [ c ] == 0 ) freq [ c ] = -1;

        pq.add ( index );

        map.get( c ).addLast( index );
        currentLength++;

        if ( currentLength == tLength ) {

            startPointer = pq.peek();
            endPointer = index;
        }

        continue;

       }

      int ele = map.get ( c ).removeFirst();
      pq.remove( ele );
      pq.add ( index );
      map.get( c ).add ( index );


      if (  (  endPointer - startPointer )  > ( index - pq.peek()  )  ) {

        startPointer = pq.peek();
        endPointer = index;

      }

    }

    return startPointer != Integer.MAX_VALUE ? s.substring( startPointer , endPointer + 1 ) : "";

    }   
}