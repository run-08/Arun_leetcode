class Solution {
    public String removeOccurrences(String s, String part) {
        int s_len = s.length();
        int len = 0;
        int p_len = part.length();
        char last_char = part.charAt(p_len-1);
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s_len;i++){
            char ch = s.charAt(i);
            stack.push(ch);
            len++;
            if(ch == last_char && len >= p_len) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < p_len;j++) sb.insert(0,stack.pop());
                String temp = sb.toString();
                if(!(temp.equals(part))) for(int j = 0;j < p_len;j++) stack.push(temp.charAt(j));
                else len -= p_len; 
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) res.append(stack.pop());
        return res.reverse().toString();
    }
}