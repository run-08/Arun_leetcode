class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder ();
        int sSize = s.length() , length = 0;
        for ( int index = 0 ; index < sSize ; index++ ) {
            char character = s.charAt ( index );
            if ( character == '%' ) {
                if ( length <= 0 ) continue;
                result = result.reverse();
            }
            else if ( character == '*' ) {
                if ( length <= 0 ) continue;
                result.delete ( length - 1 , length );
                length--;
            }
            else if ( character == '#') {
                if ( length <= 0 ) continue;
                result.append( result );
                length += length;
            }
            else {
                result.append ( character );
                length++;
            }
        }
        return result.toString();
    }
}