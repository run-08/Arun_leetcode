class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack < String > stack = new Stack <> ();
        int sLength = s.length(), scoreOfParenthesis = 0;

        for ( int index = 0 ; index < sLength ; index++ ) {

            char c = s.charAt ( index );

            if ( c == '(' ) {
                stack.push ( "(" );
                continue;
            }

            if ( stack.peek() == "(" ) {
                
                stack.pop();
                stack.push("1");
                continue;
        
            }
          
            int score = 0;

            while ( stack.peek() != "(" ) score += Integer.parseInt ( stack.pop() );
            
            stack.pop();
            score = 2 * score;

            stack.push( String.valueOf ( score ) );
        }

        while ( !stack.isEmpty() ) scoreOfParenthesis += Integer.parseInt( stack.pop() );

        return scoreOfParenthesis;
    }
}