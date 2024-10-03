class MinStack {
     Stack<Integer> stack;
     PriorityQueue<Integer> pr;
    public MinStack() {
        stack = new Stack<Integer>();
        pr = new PriorityQueue<>();
    }
    
    public void push(int val) {
         stack.push(val);
         pr.offer(val);
    }
    
    public void pop() {
        pr.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pr.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */