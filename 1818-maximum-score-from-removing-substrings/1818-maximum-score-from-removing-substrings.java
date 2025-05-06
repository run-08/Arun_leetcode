class Solution {
    public int maximumGain(String s, int x, int y) {
        int sum = 0;
        if (x > y) {
            StringBuilder sb = new StringBuilder();
            sum = removeAB(s, x, sb);  // Remove "ab" first
            sum += removeBA(sb.toString(), y);  // Then remove "ba"
        } else {
            StringBuilder sb = new StringBuilder();
            sum = removeBA(s, y, sb);  // Remove "ba" first
            sum += removeAB(sb.toString(), x);  // Then remove "ab"
        }
        return sum;
    }

    // Remove "ab" worth x points
    private int removeAB(String s, int x, StringBuilder leftover) {
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b' && !stack.isEmpty() && stack.peek() == 'a') {
                stack.pop(); // Remove 'a'
                sum += x;
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            leftover.insert(0, stack.pop());
        }
        return sum;
    }

    // Remove "ba" worth y points
    private int removeBA(String s, int y, StringBuilder leftover) {
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' && !stack.isEmpty() && stack.peek() == 'b') {
                stack.pop(); // Remove 'b'
                sum += y;
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            leftover.insert(0, stack.pop());
        }
        return sum;
    }

    // Overloaded version when leftover isn't needed
    private int removeBA(String s, int y) {
        return removeBA(s, y, new StringBuilder());
    }

    private int removeAB(String s, int x) {
        return removeAB(s, x, new StringBuilder());
    }
}
