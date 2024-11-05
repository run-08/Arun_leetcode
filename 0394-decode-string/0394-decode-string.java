class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ']'){
                 int no  = 0;
                 String concat = "";
                 while(!stack.isEmpty() && no == 0){
                     if(stack.peek().equals("[")){
                        stack.pop();
                        StringBuilder number = new StringBuilder();
                        while(!stack.isEmpty() && stack.peek().charAt(0) >= 48 && stack.peek().charAt(0) <= 57) {
                            System.out.print(number);
                            number.append(stack.pop());

                        }
                        no = Integer.parseInt(number.reverse().toString());
                     }
                     else concat += stack.pop();
                 }
                 System.out.print(no);
                 String temp = "";
                 for(int i = 0;i < no;i++) temp += concat;
                 stack.push(temp);
            }
            else stack.push(String.valueOf(c));
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) res.append(stack.pop());
        return res.reverse().toString();
    }
}