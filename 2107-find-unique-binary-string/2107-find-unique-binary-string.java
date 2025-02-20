class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();
        for(String val : nums) hs.add(val);
        int n = nums[0].length();
        return bacres(hs , "" , n);
    }
    public String bacres(HashSet<String> hs , String cur , int n){
        int len = cur.length();
        if( len == n && !hs.contains(cur))return cur;
        if(len == n) return null;
        String zeros = bacres(hs , cur+'0' , n);
        return (zeros  != null ? zeros : bacres(hs , cur+'1' , n));
    } 
}