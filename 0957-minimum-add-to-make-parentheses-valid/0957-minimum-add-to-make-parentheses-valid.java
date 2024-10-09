class Solution {
    public int minAddToMakeValid(String s) {
       Stack<Character> stack = new Stack<>();
       for(char c : s.toCharArray()){
           if(c == ')'){
            if(!stack.isEmpty()){
                 if(stack.peek() == '(') stack.pop();
                 else stack.push(')');
            }
            else stack.push(')');
           }
           else stack.push('(');
       }
       return stack.size();
    }
}