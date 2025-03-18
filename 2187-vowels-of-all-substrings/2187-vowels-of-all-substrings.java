class Solution {
    public long countVowels(String word) {
        long res = 0 , p_sum = 0;
        int n = word.length();
        for(int i = 0;i < n;i++){
            char c = word.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')  p_sum += i+1;
            res += p_sum;
        }
        return res;
    }
}