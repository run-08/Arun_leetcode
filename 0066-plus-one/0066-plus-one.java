class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> answer = new ArrayList<>();
        int carry = 1, n = digits.length;
        int idx=0;
        for(int i=n-1;i>=0;i--) {
            int ans = digits[i]+carry;
            answer.add(ans%10);
            carry = ans / 10;
        }
        if(carry != 0) answer.add(carry);
        int[] res = new int[answer.size()];
        for(int i=answer.size()-1;i>=0;i--) res[idx++] = answer.get(i);
        return res;
    }
}