class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a") ; int cnt = 1 ;
        while ( cnt < k ) {
            StringBuilder sb = new StringBuilder();
            for( int i = 0;i < cnt;i++) {
                sb.append( (char)(((word.charAt(i)-97) % 25 ) + 98) );
            }
            cnt += cnt;
            word.append(sb);
        }
        return word.charAt(k-1);
    }
}