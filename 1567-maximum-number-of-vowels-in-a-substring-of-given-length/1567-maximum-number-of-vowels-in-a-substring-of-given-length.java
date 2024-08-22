class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < k;i++){
         if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u') count++;
      sb.append(String.valueOf(s.charAt(i)));
        }
        max = count;
        for(int i = k;i < s.length();i++){
            sb.append(String.valueOf(s.charAt(i)));
         if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u') count++;
              if(sb.charAt(0) == 'a' || sb.charAt(0) == 'A' || sb.charAt(0) == 'e' || sb.charAt(0) == 'E' || sb.charAt(0) == 'i' || sb.charAt(0) == 'I' || sb.charAt(0) == 'O' || sb.charAt(0) == 'o' || sb.charAt(0) == 'U' || sb.charAt(0) == 'u') count--;
              sb.delete(0,1);
              if(count > max) max = count;
        }
        return max;
    }
}