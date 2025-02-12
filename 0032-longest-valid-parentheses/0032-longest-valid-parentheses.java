class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Stack<String> stack = new Stack<String>();
        for(int i = 0;i < n;i++) {
            if(s.charAt(i) == '(') stack.push("("+String.valueOf(i));
            else {
                if(!stack.isEmpty() && stack.peek().charAt(0) == '(') {
                    int idx = Integer.parseInt(stack.peek().substring(1));
                    arr[idx]++;
                    stack.pop();
                    arr[i] = 1;
                }
                else stack.push(")"+String.valueOf(i));
            }
        }
        int max = 0;
        int max_cur = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] == 0) {
                max = Math.max(max , max_cur);
                max_cur = 0;
            }
            else max_cur++;
        }
        max = Math.max(max , max_cur);
        return max;
    }
}