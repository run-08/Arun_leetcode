class Solution {
    public int canBeTypedWords(String text, String b) {
        HashSet<Character> hs = new HashSet<>();
        for(char c : b.toCharArray()) hs.add(c);
          int count = 0;
          for(String Data : text.split(" ")){
            boolean isFlag = true;
            for(int i = 0;i < Data.length();i++) if(hs.contains(Data.charAt(i))) isFlag = false;
            if(isFlag) count++;
          }
          return count;
    }
}