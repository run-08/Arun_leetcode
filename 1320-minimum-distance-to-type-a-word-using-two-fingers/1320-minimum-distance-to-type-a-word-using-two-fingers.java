class Solution {
    Map<String,Integer> memo;
    public int minimumDistance(String word) {
        memo = new HashMap<>();
        return helper(-1,-1,word,0);
    }
    private int helper(int i,int j,String s,int idx){
        if(idx==s.length()) return 0;
        String key = idx+", "+(i != -1 ? s.charAt(i) : -1)+", "+(j != -1 ? s.charAt(j) : -1);
        if(memo.containsKey(key)) return memo.get(key);
        // process 1st finger...
        int x1 = (s.charAt(idx)-'A')/6,y1=(s.charAt(idx)-'A')%6;
        int finger1 = 100000, finger2 = 100000;
        if(i==-1){
            finger1 = helper(idx,j,s,idx+1);
        }
        else{
            int x2=(s.charAt(i)-'A')/6,y2=(s.charAt(i)-'A')%6;
            finger1 = Math.abs(x1-x2)+Math.abs(y1-y2)+helper(idx,j,s,idx+1);
        }
        if(j==-1){
           finger2 = helper(i,idx,s,idx+1);
        }
        else{
           int x2=(s.charAt(j)-'A')/6,y2=(s.charAt(j)-'A')%6;
           finger2 = Math.abs(x1-x2)+Math.abs(y1-y2)+(helper(i,idx,s,idx+1));
        }
        memo.put(key,Math.min(finger1,finger2));
        return memo.get(key);
    }
}