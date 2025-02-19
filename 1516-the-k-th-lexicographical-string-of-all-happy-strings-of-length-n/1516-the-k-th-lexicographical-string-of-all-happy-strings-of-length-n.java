class Solution {
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        bacres("",res , n);
        if(res.size() < k) return "";
        return res.get(k-1);
    }
    public void bacres(String s , List<String> res , int n ){
         if(s.length() == n){
            res.add(s);
            return;
         }
         int len = s.length();
        for(char i = 'a' ;i <= 'c';i++)  if(len == 0 || s.charAt(len-1) != i) bacres(s+i , res , n);
    }
}