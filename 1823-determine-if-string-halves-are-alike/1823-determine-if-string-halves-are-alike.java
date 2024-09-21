class Solution {
    public boolean halvesAreAlike(String s) {
        return (compute(s.substring(0,s.length()/2)) == compute(s.substring(s.length()/2,s.length())));
    }
    public int compute(String s){
        int count = 0;
           for(int i= 0;i < s.length();i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')  count++;
           }
 return count;
    }
}