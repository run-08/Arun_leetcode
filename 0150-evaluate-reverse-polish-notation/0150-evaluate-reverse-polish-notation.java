class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String Data : tokens){
            // System.out.print(stack+"\n");
                switch(Data){
                    case("+"):
                       stack.push(stack.pop()+stack.pop());
                    break;
                    case("-") : 
                    int Data1 = stack.pop();
                    int Data2 = stack.pop();
                     stack.push(Data2-Data1);
                     break;
                     case("*"):
                     stack.push(stack.pop()*stack.pop());
                     break;
                     case("/"):
                     Data1 = stack.pop();
                      Data2 = stack.pop();
                     stack.push(Data2/Data1);
                     break;
                    default:
                       stack.push(Integer.parseInt(Data));
                }
        }
        return stack.pop();
    }
}