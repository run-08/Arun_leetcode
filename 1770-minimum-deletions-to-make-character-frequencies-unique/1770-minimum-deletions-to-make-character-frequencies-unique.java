class Solution {
    public int minDeletions(String s) {
        int n = s.length() , minDeleteCnt = 0;
        int[] freq = new int[26];
        for(int i = 0;i < n;i++)  freq[s.charAt(i) - 97]++;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < 26;i++) {
            if(freq[i] == 0) continue;
           if(!hs.contains(freq[i])) hs.add(freq[i]);
           else{
              while(hs.contains(freq[i])) {
                freq[i]--;
                minDeleteCnt++;
              }
              if( freq[i] != 0 ) hs.add( freq[i] );
           }
        }
        return minDeleteCnt;
    }
}