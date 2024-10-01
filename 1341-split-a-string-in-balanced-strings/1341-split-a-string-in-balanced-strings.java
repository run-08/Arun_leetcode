class Solution {
    public int balancedStringSplit(String s) {
        int one = 0;
        int two = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == 'R') one++;
            else two++;
            if(one == two) count++;
        }
        return count;
    }
}