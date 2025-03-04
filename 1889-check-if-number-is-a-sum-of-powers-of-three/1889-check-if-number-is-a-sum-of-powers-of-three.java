class Solution {
    public boolean checkPowersOfThree(int n) {
        return  isPowerOfThree(n , 16);
    }
    public boolean isPowerOfThree(int n , int freq){
        if(n == 0)  return true;
        if(freq <  0 || n < 0) return false;
        return isPowerOfThree(n-(int)Math.pow(3 , freq) , freq-1) || isPowerOfThree(n , freq-1);
    }
}