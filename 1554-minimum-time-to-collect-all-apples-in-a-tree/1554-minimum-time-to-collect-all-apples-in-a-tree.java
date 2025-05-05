class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer , List<Integer>> hm = new HashMap<>();
        for(int i = 0;i < n;i++) hm.put(i , new ArrayList<>());
        for(int[] edge : edges){
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }
        int cnt = 0;
        List<Integer> ls = hm.get(0);
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
         for(int node : ls) {
            if(hs.contains(node)) continue;
            hs.add(node);
           cnt +=  dfs(node , hm , hasApple , hs);
        }
        return cnt;
    }
    public int dfs(int root , HashMap<Integer , List<Integer>> hm , List<Boolean> hasApple , HashSet<Integer> visited){
          List<Integer> children = hm.get(root);
          if(children.size() == 0) return hasApple.get(root) ? 2 : 0;
          int cnt = 0;
          for(int node : children){
            if(visited.contains(node)) continue;
            visited.add(node);
            cnt  += dfs(node , hm , hasApple , visited);
          }
          return ((hasApple.get(root) || cnt >= 2)? cnt+2 : cnt);
    }
}