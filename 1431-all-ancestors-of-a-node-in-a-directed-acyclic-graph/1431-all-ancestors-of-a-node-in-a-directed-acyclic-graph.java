class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        for(int arr[] : edges) {
            List<Integer> ls = hm.getOrDefault(arr[1] , new ArrayList<>());
            ls.add(arr[0]);
            hm.put(arr[1] , new ArrayList<>(ls));
        }
        HashMap<Integer , HashSet<Integer>> memo = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(!hm.containsKey(i)) res.add(new ArrayList<>());
            else {
                List<Integer> Ancestors = new ArrayList<>();
                HashSet<Integer> unique_Ancestors = dfs( i , hm , memo);
                for(int node : unique_Ancestors) Ancestors.add(node);
                Collections.sort(Ancestors);
                res.add(Ancestors);
            } 
        }
      
        return res;
    }
   public HashSet<Integer> dfs( int child_node , HashMap<Integer , List<Integer>> hm , HashMap<Integer , HashSet<Integer>> memo){
        if(memo.containsKey(child_node)) return memo.get(child_node);
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> Ancestors = hm.get(child_node);
        for(int node : Ancestors) {
            hs.add(node);
            if(hm.containsKey(node)) hs.addAll(dfs( node , hm , memo)); 
        }
        memo.put(child_node ,hs);
        return hs;
   }
}