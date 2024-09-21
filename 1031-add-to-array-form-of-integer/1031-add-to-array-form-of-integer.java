class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int end = num.length-1;
        int carry = 0;
        while( k != 0 && end >= 0){
            int Data = num[end--]+(k % 10 )+ carry;
            k /= 10;
            carry = Data / 10;
            res.add(0,Data % 10);
        }
        while(k != 0){
            int Data = ( k % 10)+carry;
            k /= 10;
            carry = Data / 10;
            res.add(0,Data % 10);
        }
        while(end >= 0) {
            int Data = num[end--] + carry;
            carry = Data / 10;
            res.add(0,Data % 10);
        }
        if(carry != 0) res.add(0,carry);
        return res;
    }
}
