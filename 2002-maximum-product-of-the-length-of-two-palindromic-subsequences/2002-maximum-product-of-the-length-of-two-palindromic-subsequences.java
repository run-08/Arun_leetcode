class Solution {
    Map<String,Integer> map;
    public int maxProduct(String s) {
        map = new HashMap<>();
        return dfs("","",s,0);
    }
    private int dfs(String cur1,String cur2,String s,int idx){
        if(idx==s.length()) return (isPalindrome(cur1)&&isPalindrome(cur2)) ? cur1.length()*cur2.length():0 ;
        String key = cur1+","+cur2+","+idx;
        if(map.containsKey(key)) return map.get(key);
        return Math.max (
            dfs(cur1,cur2,s,idx+1),
            Math.max(
                dfs(cur1+s.charAt(idx),cur2,s,idx+1),
                dfs(cur1,cur2+s.charAt(idx),s,idx+1)
            )
        );
    }
    private boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}