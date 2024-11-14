class Solution {
    public List<Integer> partitionLabels(String s) {
      int[] freqArray = new int[26];
      for(int i = 0;i < s.length();i++) freqArray[s.charAt(i) - 97] = i;
      List<Integer>  res = new ArrayList<>();
      for(int i  = 0;i < s.length();i++){
        int max = freqArray[s.charAt(i) - 97];
        int idx = i;
        int partition = 0;
        while(idx < max){
            partition++;
            idx++;
            if(freqArray[s.charAt(idx) - 97] > max) max = freqArray[s.charAt(idx) - 97] ;
        }
        i = idx;
        res.add(++partition);
      }
      return res;
    }
}