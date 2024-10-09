class Solution {
    public String greatestLetter(String s) {
        HashSet<Integer> hs = new HashSet<>();
        for(char c : s.toCharArray()) if((int)c < 97) hs.add((int)c);
        char res  = ' ';
         for(char c : s.toCharArray()){
            if((int)c < 97) continue;
             if(!hs.contains((int)c - 32))  continue;
             if(res == ' ') res = c;
             else res =  ((int)c > (int)res ) ? c : res;
         }
         return (res == ' ') ? "" : String.valueOf((char)(res-32));
    }
}