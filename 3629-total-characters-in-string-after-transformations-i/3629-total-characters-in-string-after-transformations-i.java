class Solution {
    public int lengthAfterTransformations(String s, int t) {
         int sum = 0;
         int[] freq = new int[26];
          int mod=1_000_000_007;
         for(char c : s.toCharArray()) freq[c-97] = (freq[c-97]+1) % mod;
         for(int i = 0;i < t;i++){
              int[] arr = new int[26];
              for(int j = 0;j < 26;j++){
                 if(j == 25 && freq[j] != 0) {
                    arr[0] = (arr[0]+freq[25]) % mod;
                    arr[1] = (arr[1]+freq[25]) % mod;
                 }
                 else if( j != 25) arr[j+1] = freq[j];
              }
              freq = arr;
         }
         for(int val : freq) sum = (sum + val ) % mod;
         return sum;
    }
}