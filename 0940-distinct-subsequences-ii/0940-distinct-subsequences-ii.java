class Solution {
    public int distinctSubseqII(String S) {
      long[] freq = new long[26];
      long MOD  = 1000_000_007;
      for(char c : S.toCharArray()) freq[c-'a'] = ((Arrays.stream(freq).reduce(0,(a,b) -> ( a + b ) % MOD )) % MOD )+1;
      return (int) ((Arrays.stream(freq).reduce(0,(a,b) -> ( a + b ) % MOD )) % MOD );
    }
}