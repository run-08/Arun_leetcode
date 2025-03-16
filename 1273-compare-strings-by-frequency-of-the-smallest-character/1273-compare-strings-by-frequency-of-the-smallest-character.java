class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int  q = queries.length;
        int  w = words.length;
        int[] query_freq = new int[q];
        int[] word_freq = new int[w];
        int idx = 0;
        for(String Data : queries) {
            int s = 0;
            int e = Data.length()-1;
            char arr[] = Data.toCharArray();
            Arrays.sort(arr);
            Data = new String(arr);
            char t = Data.charAt(0);
            while(s <= e) {
                int m = s + ( e - s) / 2;
                char c = Data.charAt(m);
                if(c == t){
                   if(s == e) break;
                    else if(Data.charAt(m+1) != t) {
                        s = m;
                        break;
                    } 
                    else s = m+1;
                } 
                else e = m-1;  
            }
            query_freq[idx++] = s+1;
        }
        idx = 0;
        for(String Data : words) {
            int s = 0;
            int e = Data.length()-1;
            char arr[] = Data.toCharArray();
            Arrays.sort(arr);
            Data = new String(arr);
            char t = Data.charAt(0);
            while(s <= e) {
                int m = s + ( e - s) / 2;
                char c = Data.charAt(m);
                if(c == t){
                    if(s == e) break;
                    else if(Data.charAt(m+1) != t) {
                        s = m;
                        break;
                    } 
                    else s = m+1;
                } 
                else e = m-1;  
            }
            word_freq[idx++] = s+1;
        }
        int[] res = new int[q];
        idx = 0;
        for(int query : query_freq) {
            int min = 0;
            for(int word : word_freq) {
                if(query < word) min++;
            }
            res[idx++] = min;
        }
        return res;
    }
}