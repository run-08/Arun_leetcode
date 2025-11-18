class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length,i=0;
        if(n==1)return bits[0]==0;
        if(bits[n-1]==1) return false;
        while(i<n){
           if(bits[i]==1){
            i+=2;
            if(i>=n) return false;
            if(i==n-1) return true;
           }
           else i++;
           if(i==n-1) return true;
        }
        return false;
    }
}