class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max1 = 0;
        int max2 = 0;
        int n = answerKey.length();
        int temp = k;
        int idx = -1;
        int cur = 0;
        for(int i = 0;i < n;i++){
            if(answerKey.charAt(i) == 'F' && temp != 0) {
                if(idx == -1) idx = i;
                cur++;
                temp--;
            }
            else if(answerKey.charAt(i) == 'F' && temp == 0){
                   for(;idx < i;idx++){
                    if(answerKey.charAt(idx) == 'F'){
                        cur = (i-idx);
                        idx++;
                        break;
                    }
                   }
            }
            else cur++;
            max1 = Math.max(cur , max1);
        }
        cur = 0;
        idx = -1;
        temp = k;
        for(int i = 0;i < n;i++){
            if(answerKey.charAt(i) == 'T' && temp != 0) {
                if(idx == -1) idx = i;
                cur++;
                temp--;
            }
            else if(answerKey.charAt(i) == 'T' && temp == 0){
                   for(;idx < i;idx++){
                    if(answerKey.charAt(idx) == 'T'){
                        cur = (i-idx);
                        idx++;
                        break;
                    }
                   }
            }
            else cur++;
            max2 = Math.max(cur , max2);
        }
        return Math.max(max1 , max2);
    }
}