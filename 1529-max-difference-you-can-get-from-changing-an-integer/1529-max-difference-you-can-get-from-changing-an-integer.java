class Solution {
    public int maxDiff(int num) {
       int reversedNumber = 0;
       int temp = num;
       int maxDigit = 0;
       int tailZeros = 0;
       boolean flag = false;
       while(temp != 0) {
           reversedNumber = reversedNumber * 10 + ( temp % 10 );
           if( temp % 10 == 0 && !flag) tailZeros++;
           else flag = true;
           if(temp / 10 == 0) maxDigit = temp % 10;
           temp /= 10;
       }
       int singleDigit = maxDigit;
       if( maxDigit == 9 ) {
           temp = reversedNumber;
           while(temp != 0){
              if( (temp % 10) != 9 ) {
                maxDigit = temp % 10;
                break;
              }
              temp /= 10;
           }
       }
       temp = reversedNumber;
       int large = 0;
       while(temp != 0) {
          if(temp % 10 == maxDigit) large = large * 10 + (9);
          else large = large * 10 + (temp % 10);
          temp /= 10;
       }
       if(tailZeros != 0 && maxDigit != 0) large = (int)(large * (Math.pow(10 , tailZeros)));
       else {
           String val = String.valueOf(large);
           for(int i = 0;i < tailZeros;i++)  val += "9";
           large = Integer.parseInt(val);
       }
       int small = 0 , minDigit = singleDigit;
       boolean isZero = true;
       if(minDigit == 1) {
         temp = reversedNumber;
           while(temp != 0){
              if( (temp % 10) != 1 && temp % 10 != 0) {
                minDigit = temp % 10;
                break;
              }
              temp /= 10;
           }
           if(minDigit == 1) return large - num;
       }
       else isZero = false;
       temp = reversedNumber;
       while( temp != 0 ) {
          if( temp % 10 == minDigit ) small = small * 10 + (( isZero ? 0 : 1));
          else small = small * 10 + ( temp % 10 );
          temp /= 10;
       }
       if(tailZeros != 0) small = (int)( small * Math.pow(10 , tailZeros));
       return large - small ;
    }
}