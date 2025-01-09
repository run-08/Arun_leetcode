class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(String val : words) if(val.indexOf(pref) == 0) cnt++;
        return cnt;
    }
}