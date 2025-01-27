class Solution {
    static public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bacres(new ArrayList<>() , 0 , 1 , k , n , res);
        return res;
    }
    static void bacres(List<Integer> cur , int sum , int idx , int k , int n , List<List<Integer>> res){
        if(cur.size() >= k && sum == n){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(cur.size() >= k && (sum < n || sum > n)) return;
        if(sum > n) return;
        for(int i = idx;i <= 9;i++) {
            cur.add(i);
            bacres(new ArrayList<>(cur) , sum+i , i+1 , k , n , res);
            cur.remove(cur.size()-1);
        }
    }
}