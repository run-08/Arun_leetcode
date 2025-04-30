class Solution {
    public int maxLength(List<String> arr) {
    boolean[] freq = new boolean[26];
      return  findUnique(0 , arr , 0 , freq);
    }
    public int findUnique(int cnt , List<String> arr , int idx , boolean[] freq){
        if(idx == arr.size()) return cnt;
        String word = arr.get(idx);
        boolean[] mod_freq = new boolean[26];
        boolean[] mod1_freq = new boolean[26];
        for(int i = 0;i < 26;i++) mod1_freq[i] = freq[i];
        boolean isOkay = true;
        for(char c : word.toCharArray()){
            if(mod1_freq[c-97]) isOkay = false;
            else mod1_freq[c-97] = true;
            if(!isOkay)break;
        }
        for(int i = 0;i < 26;i++) mod_freq[i] = freq[i];
        int exclude = findUnique(cnt ,arr , idx+1 , mod_freq);
        int include = (isOkay) ? findUnique(cnt+word.length(), arr , idx+1 , mod1_freq) : cnt;
        return Math.max(include , exclude);
    }
}