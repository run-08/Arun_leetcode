class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefix_sum = 0;
        int[] arr = new int[words.length];
        int idx = 0;
        for(String word : words) arr[idx++] = (((word.charAt(0) == 'a'|| word.charAt(0) == 'e' || word.charAt(0) == 'i' ||  word.charAt(0) == 'o' || word.charAt(0) == 'u') && ( word.charAt(word.length()-1) == 'a' ||word.charAt(word.length()-1) == 'e' || word.charAt(word.length()-1) == 'i' || word.charAt(word.length()-1) == 'o' || word.charAt(word.length()-1 ) == 'u'))) ? ++prefix_sum : prefix_sum ;
        int[] res = new int[queries.length];
        for(int i = 0;i < res.length;i++){
          if(queries[i][0] == 0) res[i] = arr[queries[i][1]];
          else{
            // System.out.print(queries[i][1]+" "+queries[i][0]);
             res[i] = arr[queries[i][1]] - arr[(queries[i][0])-1];
          }
        }
        return res;  
    }
}