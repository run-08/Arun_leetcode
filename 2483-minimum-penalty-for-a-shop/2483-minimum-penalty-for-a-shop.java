class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length(),j=n,min=Integer.MAX_VALUE,countYes=0,countNo=0;
        for(int i=0;i<n;i++) if(customers.charAt(i)=='Y') countYes++;
        for(int i=0;i<n;i++){
            if(min>(countYes+countNo)){
                min=countYes+countNo;
                j=i;
            }
            if(customers.charAt(i)=='Y' && countYes > 0) countYes--;
            else countNo++;
        }
        if(min>countYes+countNo) j=n;
        return j;
    }
}