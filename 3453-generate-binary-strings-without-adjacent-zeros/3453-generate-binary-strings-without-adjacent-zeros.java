class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        getAllSubstring(res , n , "");
        return new ArrayList<>(new HashSet<>(res));
    }
    public void  getAllSubstring(List<String> res , int n , String cur){
        if(cur.length() == n){
            //  System.out.print(cur+"\n");
            if(cur.length() == 1)res.add(cur);
            else for(int i = 0;i < cur.length()-1;i++ ) if(cur.charAt(i) != '1' && cur.charAt(i+1) != '1') return;
            res.add(cur);
            return;
        }
        getAllSubstring(res , n , cur+"1");
        getAllSubstring(res , n , cur+"0");
    }
}