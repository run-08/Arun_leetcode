class Solution {
    HashMap<String,Integer> memo;
    public int minStickers(String[] stickers, String target) {
        memo = new HashMap<>();
        int ans = helper(0,target,stickers);
        return ans > 10000 ? -1 : ans;
    }
    private int helper(int idx,String cur,String[] arr){
        if(cur.length()==0) return 0;
        if(idx==arr.length) return Integer.MAX_VALUE / 2;
        String key = idx+" "+cur;
        if(memo.containsKey(key)) return memo.get(key);
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> freq = new HashMap<>();
        int min = Integer.MAX_VALUE / 2;
        String s = arr[idx];
        for(char c : s.toCharArray()) freq.put(c,freq.getOrDefault(c,0)+1);
        // just skip...
        min = Math.min(helper(idx+1,cur,arr),min);
        // modify...
        boolean isChanged = false;
        for(char c : cur.toCharArray()){
            if(freq.containsKey(c)){
                isChanged = true;
                freq.put(c,freq.get(c)-1);
                if(freq.get(c)==0) freq.remove(c);
            } 
            else sb.append(c);
        }
        if(isChanged) {
            min = Math.min(
            1+helper(idx,sb.toString(),arr)
            ,Math.min(
                1+helper(idx+1,sb.toString(),arr),min
              ));
        }
        memo.put(key,min);
        return min;
    }
}