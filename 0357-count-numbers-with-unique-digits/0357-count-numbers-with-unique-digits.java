class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int cnt = 0;
        n = (int)Math.pow(10 , n);
        for(int i = 0;i < n;i++){
            int[] arr = new int[10];
            boolean isUnique = true;
            int ele = i;
             while(ele != 0 && isUnique){
                if(arr[(ele % 10)] != 0) isUnique = false;
                else arr[(ele % 10)]++;
                ele /= 10;
             }
             if(isUnique) cnt++;
        }
        return cnt;
    }
}