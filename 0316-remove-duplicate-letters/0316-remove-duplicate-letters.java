class Solution {
    public String removeDuplicateLetters(String s) {
      Stack<Character> stack = new Stack<>();
      HashMap<Character , Integer> hm = new HashMap<>();
      HashSet<Character> hs = new HashSet<>();
      for(int i = 0;i < s.length();i++) hm.put(s.charAt(i),i);
      for(int i = 0;i < s.length();i++){
            if(hs.contains(s.charAt(i))) continue;
            if(stack.isEmpty() || stack.peek() < s.charAt(i)){
                stack.push(s.charAt(i));
                hs.add(s.charAt(i));
                continue;
            }
            while(!stack.isEmpty()){
                if(stack.peek() < s.charAt(i) || hm.get(stack.peek()) < i) break;
               else if (hm.get(stack.peek()) > i) hs.remove(stack.pop());
            }
             stack.push(s.charAt(i));
             hs.add(s.charAt(i));
        }
        String res = "";
        for(Character c : stack) res += String.valueOf(c);
        return res;
    }
}