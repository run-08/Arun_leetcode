class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] visited = new int[26];
        int cnt = 0;
       for(int i = 0;i < s.length();i++) {
         if(visited[s.charAt(i) - 'a'] == 1) continue;
         int st = i+1;
         int e = i;
         for(int j = 0;j < s.length();j++) if(s.charAt(j) == s.charAt(i)) e = j;
         HashSet hs = new HashSet<>();
         while( st <= e-1) hs.add(s.charAt(st++)); 
         visited[s.charAt(i) - 'a'] = 1;
         cnt += hs.size();
       }
       return cnt;
    }
}