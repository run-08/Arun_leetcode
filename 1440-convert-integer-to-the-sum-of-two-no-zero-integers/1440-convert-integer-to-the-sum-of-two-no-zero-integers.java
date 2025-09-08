class Solution {

    public int[] getNoZeroIntegers(int n) {

        for ( int index = 1 ; index <= n/2 ; index++ ) {

            int complicated = n - index;

            if (  isZeroPresent( index ) &&  isZeroPresent ( complicated ) ) return new int [] {  index, n - index };

        }
        
        return new int [ ] { 0, 0 };
        
    }

    private boolean isZeroPresent ( int num ) {

        while ( num != 0 ) {

            if ( num % 10 == 0 ) return false;
            num /= 10;

        } 

        return true;
    }
}
