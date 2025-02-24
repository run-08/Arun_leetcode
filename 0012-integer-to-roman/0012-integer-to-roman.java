class Solution {
    public String intToRoman(int num) {
        int[] arr = {1,4,5,9,10,40,50,90,100,400,500,900,1000, 10000};
        String arr_roman[] = {"I" , "IV" , "V" , "IX" , "X" , "XL" , "L" , "XC" , "C" , "CD" , "D"  , "CM" , "M", "H"};
        return bacres(num , arr , arr_roman , 13 , "");
    }
    public String bacres(int n , int[] arr , String[] rom , int idx , String cur ){
        if(idx < 0) return null;
        if(n == 0) return cur;
        if(arr[idx] <= n) return bacres(n-arr[idx] , arr , rom , idx, cur+rom[idx]);
        return bacres(n , arr , rom , idx-1 , cur);
    }
}