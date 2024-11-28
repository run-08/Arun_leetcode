class Solution {
    public int minimumChairs(String s) {
        int min_chair = 0;
        int max_entry = 0;
        for(int  i = 0;i < s.length();i++){
            if(s.charAt(i) == 'E') {
                if(max_entry + 1 > min_chair) min_chair++;
                max_entry++;
            }
            else max_entry--;
        }
        return min_chair;
    }
}