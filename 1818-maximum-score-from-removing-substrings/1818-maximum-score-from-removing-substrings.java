class Solution {
    Stack<Character> stack = new Stack<>();
    public int maximumGain(String s, int x, int y) {
        int sum = 0;
       if(x > y ) {
        sum = X( s , x , y ) ;
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0 , stack.pop());
        sum += Y( sb.toString() , x , y );
       }
       else  {
        sum = Y( s , x , y ); 
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0 , stack.pop());
        sum += X( sb.toString() , x , y );
       }
       return sum;
    }
    // for x
    public int X(String s , int x , int y){
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c == 'b') {
                if(!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    sum += x;
                }
                else stack.push(c);
            }
            else stack.push(c);
        }
        return sum;
    }
    // for Y
    public int Y(String s , int x , int y){
        int sum = 0;
      for(char c : s.toCharArray()) {
            if(c == 'a') {
                if(!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    sum += y;
                }
                else stack.push(c);
            }
            else stack.push(c);
        }
        return sum;
    }
}