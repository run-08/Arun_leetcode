class Solution {
    public String convert(String s, int numRows) {
        int pointer = 0;
        String status = "in";
        if(numRows == 1) return s;
        HashMap<Integer , List<Character>> hm = new HashMap<>();
        for(int i = 0;i < numRows ;i++) hm.put(i , new ArrayList<Character>());
        String res = "";
         for(int i = 0;i < s.length();i++) {
             hm.get(pointer).add(s.charAt(i));
              if(pointer == numRows-1) status = "dec";
              if(pointer == 0) status = "in";
              pointer += (status == "in") ? 1 : -1;
         }  
        for(int i = 0;i < numRows;i++){
            List<Character> result = hm.get(i);
            for(int j = 0;j < result.size();j++) res += String.valueOf(result.get(j));
        }
        return res;
    }
}