class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ls = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length-1;i >= 0;i--){
            int Data = digits[i]+carry;
            carry = Data / 10;
            ls.add(Data % 10);
        }
        if(carry != 0) ls.add(carry);
        int[] res = new int[ls.size()];
        for(int i = ls.size()-1;i >= 0;i--) res[ls.size()-i-1] = ls.get(i);
        return res;
    }
}