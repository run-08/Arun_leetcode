class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i  = 0;i < strs[0].length();i++){
           char prev = ' ';
           for(String val : strs) {
            if(prev != ' ' && prev > val.charAt(i)){
               count++;
               break;
            }
            else prev = val.charAt(i);
           }
        }
        return  count;
    }
}