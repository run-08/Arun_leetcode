class Solution {
    public String freqAlphabets(String s) {
        String res = "";
      for(int i = s.length()-1;i >= 0;i--){
        if(s.charAt(i) == '#'){
            int Data = Integer.parseInt(s.substring(i-2,i));
            res += (char)(Data+96);
            i -= 2;
        }
        else  res += (char)(Character.getNumericValue(s.charAt(i))+96);
      }
      StringBuilder sb = new StringBuilder(res);
      return sb.reverse().toString();
    }
}