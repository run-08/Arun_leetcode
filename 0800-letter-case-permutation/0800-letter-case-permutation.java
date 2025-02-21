class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        s = s.toLowerCase();
        bacres( s , res , "" , 0);
        return res;
    }
    public void bacres(String s , List<String> res , String cur, int idx){
      if(idx == s.length()){
        res.add(cur);
        return;
      }
      char c = s.charAt(idx);
      bacres(s , res , cur+c , idx+1);
      if(c >= 97 && c <= 122) bacres(s , res , cur+(char)(c-32) , idx+1);
    }
}