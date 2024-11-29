class Solution {
    public String removeDuplicateLetters(String s) {
      Stack<Character> stack = new Stack<>();
      HashMap<Character , Integer> hm = new HashMap<>();
      HashSet<Character> hs = new HashSet<>();
      for(int i = 0;i < s.length();i++) hm.put(s.charAt(i),i);
      for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(hs.contains(c)) continue;
            if(stack.isEmpty() || stack.peek() < c){
                stack.push(c);
                hs.add(c);
                continue;
            }
            while(!stack.isEmpty()){
                char peek = stack.peek();
                if(peek < c || hm.get(peek) < i) break;
                 hs.remove(stack.pop());
            }
             stack.push(c);
             hs.add(c);
        }
        String res = "";
        for(Character c : stack) res += String.valueOf(c);
        return res;
    }
}