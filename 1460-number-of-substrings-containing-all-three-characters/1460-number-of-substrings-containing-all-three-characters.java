class Solution {
    public int numberOfSubstrings(String s) {
         int a = -1;
         int b = -1;
         int c = -1;
         int res = 0;
         int n = s.length();
         for(int i = 0;i < n;i++){
             if(s.charAt(i) == 'a') a = i;
                 else if(s.charAt(i) == 'b') b = i;
                 else c = i;
                 if(a != -1 && b != -1 && c != -1) {
                 int idx = Math.min(Math.min(a , b ), c);
                 res += (idx-0)+1;
            }
            else {
               if(s.charAt(i) == 'a') {
                a= i;
                 if(a != -1 && b != -1 && c != -1) res = 1;
                }
               else if(s.charAt(i) == 'b') {
                b = i;
                 if(a != -1 && b != -1 && c != -1) res = 1;
                }
                else {
                c = i;
                 if(a != -1 && b != -1 && c != -1) res = 1;
                }
            }
         }
         return res;
    }
}