class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int idx = 0;
        while(n != 0){
             if((n % 2 == 1)) res[idx % 2] += 1; 
             n = n / 2;
             idx++;
        }
        return res;
    }
}