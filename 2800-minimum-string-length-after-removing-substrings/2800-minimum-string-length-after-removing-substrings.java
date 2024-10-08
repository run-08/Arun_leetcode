class Solution {
    public int minLength(String s) {
        // Stack<Character> stack = new Stack<Character>();
        // boolean reduce = false;
        // for(char c : s.toCharArray()){
        //     if(stack.isEmpty()){
        //         stack.push(c);
        //         continue;
        //     }
        //     if((int)c - (int)stack.peek() == 1 && (int)stack.peek() % 2 != 0 && (int)c % 2 == 0) {
        //         System.out.print(stack);
        //         stack.push(c);
        //         reduce = true;
        //         continue;
        //     }
        //   if(reduce){
        //      reduce = false;
        //     while(!stack.isEmpty()){
        //       int data = stack.pop();
        //       if(!stack.isEmpty() && (int)stack.peek()-(int)data != 1){
        //         stack.pop();
        //         break;
        //       }
        //   }
        //   }
        //   if(stack.isEmpty()) stack.push(c);
        //   else {
        //     if((int)c - (int)stack.peek() == 1  && (int)stack.peek() % 2 != 0 && (int)c % 2 == 0) reduce = true;
        //     stack.push(c);
        //    }
        // }
        // // System.out.print(stack);
        // while(!stack.isEmpty()){
        //    int Data = (int)stack.pop();
        //    if(stack.isEmpty()) return 1;
        //    else if(Data - (int)stack.peek() != 1 ||  (int)Data % 2 != 0 || (int)stack.peek() % 2 == 0){
        //     stack.push((char)Data);
        //     break;
        //    }
        //    else stack.pop();
        // }
        // return stack.size();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if(stack.peek() == 'A' && c == 'B' || stack.peek() == 'C' && c == 'D') stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }
}