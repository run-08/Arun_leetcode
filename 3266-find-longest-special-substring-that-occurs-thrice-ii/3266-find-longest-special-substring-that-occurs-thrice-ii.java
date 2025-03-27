class Solution {
    HashMap<Character , List<Integer>> indices;
    public int maximumLength(String s) {
        indices = new HashMap<>();
        int n = s.length() , max = -1;
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
           if(indices.containsKey(c)) {
               if(hm.get(c) == i-1) {
                  int size = indices.get(c).size();
                  indices.get(c).set(size-1 , indices.get(c).get(size-1)+1);
               }
               else indices.get(c).add(1);
               hm.put(c,i);
           }
           else {
            hm.put(c,i);
            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            indices.put(c , new ArrayList<>(ls));
           }
        }
       for(char c = 'a' ; c <= 'z';c++) {
         if(!hm.containsKey(c)) continue;
         List<Integer> ls = indices.get(c);
         int size = ls.size();
         Collections.sort(ls);
         if(size == 1){
            if(ls.get(0) < 3) continue;
             max = Math.max(ls.get(0)-2 , max);
         }
         else if(size == 2) {
            int high = ls.get(1);
            int min = ls.get(0);
            if(high+min < 3) continue;
            if(high == min) max = Math.max(high-1 , max);
            else if(high-2 > min) max = Math.max(high-2 , max); 
            else max = Math.max(min , max);
         }
         else {
              int high = ls.get(size-1);
              int min = ls.get(size-2);
              int three = ls.get(size-3);
              if(high == min && min == three ) max = Math.max(three , max);
              else {
                if(high+min < 3) continue;
                if(high == min) max = Math.max(high-1 , max);
                else if(high-2 > min) max = Math.max(high-2 , max); 
                else max = Math.max(min , max);                     
              }
         }
       }
       return max;
    }
}