class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int pref_and_suf = 0;
        for(int i = 0;i < words.length-1;i++) for(int j = i+1;j < words.length;j++) if(words[i].length() <= words[j].length() && words[i].equals(words[j].substring(0,words[i].length())) && words[i].equals(words[j].substring(words[j].length()-words[i].length(),words[j].length())))  pref_and_suf++;
        return  pref_and_suf;
    }
}