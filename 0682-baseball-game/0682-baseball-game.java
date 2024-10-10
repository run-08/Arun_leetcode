class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String Data : operations){
            if(Data.equals("+")){
                int poped_val = stack.pop();
                int value = (poped_val+stack.peek());
                stack.push(poped_val);
                stack.push(value);
            }
            else if(Data.equals("C")) stack.pop();
            else if(Data.equals("D")) stack.push(2*stack.peek());
            else stack.push(Integer.parseInt(Data));
        }
        if(stack.size() == 0) return 0;
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
}