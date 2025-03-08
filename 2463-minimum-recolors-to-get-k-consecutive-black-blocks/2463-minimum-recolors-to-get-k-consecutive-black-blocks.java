class Solution {
    public int minimumRecolors(String s, int k) {
        int min = 0;
        int no_of_whites = 0;
        int n = s.length();
        for(int i = 0;i < k;i++) if(s.charAt(i) == 'W') no_of_whites++;
        min = no_of_whites;
        for(int i = k;i < n;i++){
            if(s.charAt(i) == 'W') no_of_whites++;
            if(s.charAt(i-k) == 'W') no_of_whites--;
            min = Math.min(no_of_whites , min);
        }
        return min;
    }
}