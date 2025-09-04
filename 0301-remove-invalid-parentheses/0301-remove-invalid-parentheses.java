class Solution {

    public List<String> removeInvalidParentheses(String s) {
        
         int  sLength = s.length() , max = 0;
         Queue < Paran > q = new ArrayDeque();
         ArrayList < String > res = new ArrayList<>();
         HashSet < String > DP = new HashSet <> ();

         q.offer( new Paran ( 0, new StringBuilder(), 0 ) );

         while ( !q.isEmpty() ) {

            Paran paran= q.poll();

            StringBuilder current = new StringBuilder ( paran.current );
            int index = paran.index ;
            int valid = paran.valid;

            String key = current + "," + index + "," + valid;
            
            if( !DP.add( key ) ) continue;

            if ( paran.index >= sLength ) {

                if ( paran.valid == 0 ) {
         
                        if ( max > paran.current.length() ) continue;

                        else if ( max < paran.current.length() )  res = new ArrayList <> ();

                        res.add ( new String( paran.current.toString() ) );

                        max = Math.max ( max , paran.current.length() );

                }

                continue;
            }

            else if (  paran.valid < 0  ) continue;

            if ( s.charAt (  paran.index )  >= 'a' && s.charAt ( paran.index )  <= 'z' ) {

               

               current.append( s.charAt ( index ) );
               index += 1;
               q.offer ( new Paran ( index , current , valid ) );

               continue;

            }

            if ( s.charAt ( paran.index ) == '(' ) {
  
                   q.offer ( new Paran( index + 1 , new StringBuilder( current ).append("("), valid + 1 ) );
                   q.offer ( new Paran ( index + 1 , current, valid ) );

            }

            else {

                  q.offer ( new Paran( index + 1 , new StringBuilder( current ).append(")"), valid - 1 ) );
                  q.offer ( new Paran ( index + 1 , current, valid ) );

            }
            

         }

         return res;

    }
}
class Paran{
     
     int index;
     StringBuilder current;
     int valid;

     Paran ( int index , StringBuilder current , int valid ) {
        
        this.index = index;
        this.current = current;
        this.valid = valid;

     }
}