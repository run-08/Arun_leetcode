class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] freq = new char[26];
        int n = s1.length();
        for( int i = 0;i < 26;i++ ) freq[i] = (char)(97+i);
        for(int i = 0;i < n;i++){
            char a = get( freq , s1.charAt(i) );
            char b = get( freq , s2.charAt(i) );
            if(a == freq[a - 97] && b == freq[b -97 ]){
                if(a < b) freq[b-97] = a;
                else freq[ a - 97 ] = b;
            }
            else {
                 if(a < b) set(freq , a , b );
                 else set(freq , b , a );
            }
        }
        String res = "";
        for(char c : baseStr.toCharArray()){
            c = get(freq , c);
            res += c;
        }
        return res;
    }
    private char get(char[] freq , char c){
         while(freq[c-97] != c) c = freq[c-97];
         return c;
    }
    private void set(char[] freq , char c , char replacement){
        boolean isCSuccess = false;
        while(!isCSuccess) {
            replacement = freq[ replacement - 97 ];
            if(replacement < c){
                freq[ c - 97 ] = replacement;
                return;
            }
            else if (replacement == freq[ replacement - 97]) {
                freq[ replacement - 97 ] = c;
                break;
            }
        }
    }
}