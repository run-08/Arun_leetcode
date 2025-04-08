class Solution {
    public int countVowelSubstrings(String word) {
        HashMap<Character , Integer> hm = new HashMap<>();
        int originate = -1 , res = 0 ,n = word.length();
        for(int i = 0;i < n;i++) {
            if(!isVowel(word.charAt(i))) {
                hm.clear();
                originate = -1;
                continue;
            }
            if(originate == -1) {
                originate = i;
                hm.put(word.charAt(i) , i);
            }
            else {
                hm.put(word.charAt(i) , i);
                if(hm.size() == 5) {
                   int min = hm.get('a');
                   min = Math.min(min , hm.get('i'));
                   min = Math.min(min , hm.get('e'));
                   min = Math.min(min , hm.get('o'));
                   min = Math.min(min , hm.get('u'));
                   res += (min-originate)+1;
                }
            }
        }
        return res;
    }
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}